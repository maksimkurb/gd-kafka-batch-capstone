package ru.cubly.pet.consumer.component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;
import ru.cubly.pet.model.HddReport;

@Component
@Slf4j
public class Receiver implements MessageListener<String, HddReport> {
    private final HddReportRepository hddReportRepository;

    private final Counter reportsAddedCounter;
    private final Counter reportsIgnoredCounter;

    public Receiver(HddReportRepository hddReportRepository, MeterRegistry meterRegistry) {
        this.hddReportRepository = hddReportRepository;

        this.reportsAddedCounter = meterRegistry.counter("reportsAdded");
        this.reportsIgnoredCounter = meterRegistry.counter("reportsIgnored");
    }

    @Override
    public void onMessage(ConsumerRecord<String, HddReport> data) {
        HddReport value = data.value();
        if (value == null
        || value.getDate() == null
        || value.getSerialNumber() == null
        || value.getModel() == null) {
            log.warn("Filtering out entity. Value={}", value);
            reportsIgnoredCounter.increment();
            return;
        }
        hddReportRepository.save(value);
        reportsAddedCounter.increment();
        log.debug("Entity saved to database. Value={}", value);
    }
}
