package ru.cubly.pet.analyzer.component.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.cubly.pet.analyzer.component.AnalyticsByModelRepository;
import ru.cubly.pet.analyzer.component.HddInfoItemAttributeCopier;
import ru.cubly.pet.model.AnalyticsByModel;
import ru.cubly.pet.model.HddReport;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
@Slf4j
@StepScope
public class HddReportItemsProcessor implements ItemProcessor<List<HddReport>, AnalyticsByModel> {
    @Autowired
    HddInfoItemAttributeCopier attributeCopier;

    @Autowired
    AnalyticsByModelRepository analyticsByModelRepository;

    @Value("#{jobParameters['model']}")
    private String model;

    @Override
    public AnalyticsByModel process(List<HddReport> hddReports) throws Exception {
        log.info("Processing hdd report entities. Count={}", hddReports.size());

        AnalyticsByModel analytics = analyticsByModelRepository
                .findById(model)
                .orElseGet(() -> {
                    AnalyticsByModel value = new AnalyticsByModel();
                    value.setModel(model);
                    return value;
                });

        HddReport sum = new HddReport();

        for (HddReport report : hddReports) {
            attributeCopier.copyAttributes(report, sum, this::add);
        }

        long analyticsCnt = analytics.getTotalEvents();
        int sumCnt = hddReports.size();

        attributeCopier.copyAttributes(sum, analytics, (sourceSupplier, targetSupplier, targetConsumer) -> {
            average(sumCnt, normalizeValue(analyticsCnt), sourceSupplier, targetSupplier, targetConsumer);
        });

        analytics.setTotalEvents(analyticsCnt + sumCnt);
        return analytics;
    }

    private Long normalizeValue(Long value) {
        return value == null ? 0 : value;
    }

    private void add(Supplier<Long> sourceSupplier, Supplier<Long> targetSupplier, Consumer<Long> targetConsumer) {
        Long src = sourceSupplier.get();
        Long target = targetSupplier.get();
        targetConsumer.accept(normalizeValue(src) + normalizeValue(target));
    }

    private void average(long sourceCount, long targetCount, Supplier<Long> sourceSupplier, Supplier<Long> targetSupplier, Consumer<Long> targetConsumer) {
        BigInteger sourceValue = BigInteger.valueOf(normalizeValue(sourceSupplier.get())).divide(BigInteger.valueOf(Math.max(sourceCount, 1)));
        BigInteger targetValue = BigInteger.valueOf(normalizeValue(targetSupplier.get()));
        targetConsumer.accept(sourceValue.add(targetValue).divide(BigInteger.valueOf(2)).longValue());
    }

}
