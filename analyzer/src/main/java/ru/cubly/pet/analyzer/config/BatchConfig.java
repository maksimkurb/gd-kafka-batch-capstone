package ru.cubly.pet.analyzer.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.cubly.pet.analyzer.component.task.HddAnalyticsTasklet;
import ru.cubly.pet.model.AnalyticsByModel;
import ru.cubly.pet.model.HddReport;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Collections;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    private static final String QUERY_LOAD_REPORTS =
            "SELECT r FROM report r WHERE processed IS FALSE AND model = :model";
    private static final String QUERY_UPDATE_REPORTS =
            "UPDATE report SET processed = true WHERE model = :model AND serial_number = :serialNumber and date = :date";
    public static final String HDD_ANALYTICS_BY_MODEL_JOB = "hddAnalyticsByModelJob";

    @Value("${hdd.batch.chunkSize}")
    private int chunkSize;

    @Bean
    @StepScope
    public ItemStreamReader<HddReport> itemReader(@Value("#{jobParameters['model']}") String model,
                                                  EntityManagerFactory entityManagerFactory) {
        return new JpaPagingItemReaderBuilder<HddReport>()
                .name("hddReportReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString(QUERY_LOAD_REPORTS)
                .parameterValues(Collections.singletonMap("model", model))
                .pageSize(chunkSize)
                .build();
    }

    @Bean
    public ItemWriter<AnalyticsByModel> analyticsByModelItemWriter(EntityManagerFactory entityManagerFactory) {
        return new JpaItemWriterBuilder<AnalyticsByModel>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }

    @Bean
    public ItemWriter<HddReport> hddReportItemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<HddReport>()
                .dataSource(dataSource)
                .sql(QUERY_UPDATE_REPORTS)
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .build();
    }

    @Bean
    protected Step processLines(StepBuilderFactory steps,
                                HddAnalyticsTasklet tasklet) {
        return steps
                .get("processTask")
                .tasklet(tasklet)
                .build();
    }

    @Bean
    public Job hddAnalyticsByModelJob(JobBuilderFactory jobBuilderFactory,
                                      Step processLines) {
        return jobBuilderFactory
                .get(HDD_ANALYTICS_BY_MODEL_JOB)
                .start(processLines)
                .build();
    }
}
