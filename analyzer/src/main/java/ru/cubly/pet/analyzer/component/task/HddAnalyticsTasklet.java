package ru.cubly.pet.analyzer.component.task;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.*;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.cubly.pet.model.AnalyticsByModel;
import ru.cubly.pet.model.HddReport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class HddAnalyticsTasklet implements Tasklet {
    @Autowired
    private ItemStreamReader<HddReport> itemReader;

    @Autowired
    private ItemProcessor<List<HddReport>, AnalyticsByModel> hddReportItemsProcessor;

    @Autowired
    private ItemWriter<AnalyticsByModel> analyticsByModelItemWriter;

    @Autowired
    private ItemWriter<HddReport> hddReportItemWriter;

    @Value("${hdd.batch.chunkSize}")
    private int chunkSize;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        itemReader.open(new ExecutionContext());

        List<HddReport> items = new ArrayList<>();
        HddReport readItem = itemReader.read();

        int counter = 0;
        while(readItem != null) {
            items.add(readItem);
            readItem = itemReader.read();

            counter++;
            if (chunkSize == counter) {
                AnalyticsByModel result = hddReportItemsProcessor.process(items);
                analyticsByModelItemWriter.write(Collections.singletonList(result));
                hddReportItemWriter.write(items);
                counter = 0;
                items.clear();
            }
        }
        if (counter > 0) {
            AnalyticsByModel result = hddReportItemsProcessor.process(items);
            analyticsByModelItemWriter.write(Collections.singletonList(result));
            hddReportItemWriter.write(items);
        }

        itemReader.close();
        return RepeatStatus.FINISHED;
    }

}
