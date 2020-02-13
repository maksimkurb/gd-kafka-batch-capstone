package ru.cubly.pet.producer.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import ru.cubly.pet.Processor;
import ru.cubly.pet.model.HddReport;

@Slf4j
public class HddReportProcessor implements Processor<HddReport> {
    @Value("${hdd.producer.kafkaTopic}")
    private String hddReportTopic = "hddReport";

    private final KafkaTemplate<String, HddReport> kafkaTemplate;

    public HddReportProcessor(KafkaTemplate<String, HddReport> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void process(HddReport value) {
        kafkaTemplate.send(hddReportTopic, value);
    }
}
