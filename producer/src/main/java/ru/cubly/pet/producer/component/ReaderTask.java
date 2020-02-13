package ru.cubly.pet.producer.component;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.cubly.pet.Processor;
import ru.cubly.pet.model.HddReport;
import ru.cubly.pet.producer.config.HddProducerProperties;

import java.io.*;
import java.nio.channels.FileLock;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Component
@Slf4j
public class ReaderTask implements ApplicationRunner {

    private final HddProducerProperties props;
    private final CsvSchema schema;
    private final Processor<HddReport> processor;

    public ReaderTask(HddProducerProperties props,
                      @Qualifier("inboundFileSchema") CsvSchema schema,
                      Processor<HddReport> processor) {
        this.props = props;
        this.schema = schema;
        this.processor = processor;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Reader task running with properties: inboundDir={} workingDir={} archiveDir={}",
                props.getInboundDir(),
                props.getWorkingDir(),
                props.getArchiveDir());

        if (StringUtils.isEmpty(props.getInboundDir())
        || StringUtils.isEmpty(props.getWorkingDir())
        || StringUtils.isEmpty(props.getArchiveDir())) {
            log.error("Some of directories are not configured: inboundDir={}, workingDir={}, archiveDir={}",
                    props.getInboundDir(),
                    props.getWorkingDir(),
                    props.getArchiveDir());
            return;
        }

        Path inboundDir = Paths.get(props.getInboundDir());
        Path workingDir = Paths.get(props.getWorkingDir());
        Path archiveDir = Paths.get(props.getArchiveDir());

        if (!isWritableDirectory(inboundDir)) {
            log.error("Inbound directory is not exists or it's not writable. Type=inbound, Path={}", inboundDir.toAbsolutePath().toString());
            return;
        }
        if (!isWritableDirectory(workingDir)) {
            log.error("Working directory is not exists or it's not writable. Type=working, Path={}", inboundDir.toAbsolutePath().toString());
            return;
        }
        if (!isWritableDirectory(archiveDir)) {
            log.error("Archive directory is not exists or it's not writable. Type=ready, Path={}", inboundDir.toAbsolutePath().toString());
            return;
        }

        try {
            scanInboundDir(inboundDir, workingDir, archiveDir);
            pollInboundDir(inboundDir, workingDir, archiveDir);

            log.info("Polling finished");
        } catch (Exception e) {
            log.error("Exception occurred while polling inbound directory.", e);
        }
    }

    private boolean isWritableDirectory(Path path) {
        return Files.isDirectory(path) && Files.isWritable(path);
    }



    private void scanInboundDir(Path inboundDir, Path workingDir, Path archiveDir) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(inboundDir)) {
            for (Path filePath : stream) {
                boolean isRegularFile = Files.isRegularFile(filePath);
                boolean shouldProcess = isRegularFile && filePath.getFileName().toString().endsWith(".csv");

                log.info("File detected: Path={}, Type={}, Process={}", filePath.toAbsolutePath().toString(), isRegularFile ? "file" : "directory", shouldProcess);

                if (shouldProcess) {
                    scheduleProcessing(filePath, workingDir, archiveDir);
                }
            }
        }
    }

    private void pollInboundDir(Path inboundDir, Path workingDir, Path archiveDir) throws IOException, InterruptedException {
        WatchService watcher = inboundDir.getFileSystem().newWatchService();
        inboundDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);


        while (true) {
            WatchKey watchKey = watcher.take();
            List<WatchEvent<?>> events = watchKey.pollEvents();
            for (WatchEvent<?> event : events) {
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    Path filePath = Paths.get(inboundDir.toString(), event.context().toString());
                    boolean isRegularFile = Files.isRegularFile(filePath);
                    boolean shouldProcess = isRegularFile && filePath.getFileName().toString().endsWith(".csv");

                    log.info("New file detected: Path={}, Type={}, Process={}", filePath.toAbsolutePath().toString(), isRegularFile ? "file" : "directory", shouldProcess);

                    if (shouldProcess) {
                        scheduleProcessing(filePath, workingDir, archiveDir);
                    }
                }
            }
            boolean valid = watchKey.reset();
            if (!valid) {
                log.error("Failed to reset file watcher. Directory is inaccessible.");
                break;
            }
        }
    }

    private void processFile(Path filePath, Path workingDir, Path archiveDir) throws IOException {
        try {
            filePath = Files.move(filePath, workingDir.resolve(filePath.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.warn("Can not move file to working dir, skipping it. Path={}", filePath.toString(), e);
            return;
        }

        Reader in = Files.newBufferedReader(filePath);

        CsvMapper mapper = new CsvMapper();
        MappingIterator<HddReport> it = mapper.readerFor(HddReport.class).with(schema)
                .readValues(in);

        while (it.hasNextValue()) {
            HddReport value = it.nextValue();

            log.debug("Processing hdd report. Date={} Serial={} Model={}", value.getDate(), value.getSerialNumber(), value.getModel());
            processor.process(value);
        }
        log.info("Finished file processing. Path={}", filePath.toString());

        try {
            filePath = Files.move(filePath, archiveDir.resolve(filePath.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.warn("Can not move file to archive dir. Path={}", filePath.toString(), e);
        }
    }

    private void scheduleProcessing(Path filePath, Path workingDir, Path archiveDir) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(() -> {
            if (isLocked(filePath)) {
                scheduleProcessing(filePath, workingDir, archiveDir);
            } else {
                try {
                    processFile(filePath, workingDir, archiveDir);
                } catch (IOException e) {
                    log.error("Failed to process file", e);
                }
            }
        }, 5, TimeUnit.SECONDS);
    }

    private boolean isLocked(Path filePath) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(filePath.toAbsolutePath().toString(), "rw");
        } catch (IOException e) {
            return true;
        }
        FileLock lock = null;
        try {
            lock = raf.getChannel().tryLock();
            if (lock == null) return true;
            raf.close();
        } catch (IOException e) {
            return true;
        }
        return false;
    }
}
