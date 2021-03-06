package ru.cubly.pet.producer.config;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import ru.cubly.pet.Processor;
import ru.cubly.pet.model.HddReport;
import ru.cubly.pet.producer.component.HddReportProcessor;

@Configuration
public class HddReportAppConfig {

    @Bean
    public Processor<HddReport> hddReportProcessor(KafkaTemplate<String, HddReport> kafkaTemplate) {
        return new HddReportProcessor(kafkaTemplate);
    }

    @Bean
    @Qualifier("inboundFileSchema")
    public CsvSchema inboundFileSchema() {
        return CsvSchema.builder()
                .setSkipFirstDataRow(true)
                .addColumn("date")
                .addColumn("serial_number")
                .addColumn("model")
                .addColumn("capacity_bytes")
                .addColumn("failure")
                .addColumn("smart_1")
                .addColumn("smart_1_raw")
                .addColumn("smart_2")
                .addColumn("smart_2_raw")
                .addColumn("smart_3")
                .addColumn("smart_3_raw")
                .addColumn("smart_4")
                .addColumn("smart_4_raw")
                .addColumn("smart_5")
                .addColumn("smart_5_raw")
                .addColumn("smart_7")
                .addColumn("smart_7_raw")
                .addColumn("smart_8")
                .addColumn("smart_8_raw")
                .addColumn("smart_9")
                .addColumn("smart_9_raw")
                .addColumn("smart_10")
                .addColumn("smart_10_raw")
                .addColumn("smart_11")
                .addColumn("smart_11_raw")
                .addColumn("smart_12")
                .addColumn("smart_12_raw")
                .addColumn("smart_13")
                .addColumn("smart_13_raw")
                .addColumn("smart_15")
                .addColumn("smart_15_raw")
                .addColumn("smart_16")
                .addColumn("smart_16_raw")
                .addColumn("smart_17")
                .addColumn("smart_17_raw")
                .addColumn("smart_22")
                .addColumn("smart_22_raw")
                .addColumn("smart_23")
                .addColumn("smart_23_raw")
                .addColumn("smart_24")
                .addColumn("smart_24_raw")
                .addColumn("smart_168")
                .addColumn("smart_168_raw")
                .addColumn("smart_170")
                .addColumn("smart_170_raw")
                .addColumn("smart_173")
                .addColumn("smart_173_raw")
                .addColumn("smart_174")
                .addColumn("smart_174_raw")
                .addColumn("smart_177")
                .addColumn("smart_177_raw")
                .addColumn("smart_179")
                .addColumn("smart_179_raw")
                .addColumn("smart_181")
                .addColumn("smart_181_raw")
                .addColumn("smart_182")
                .addColumn("smart_182_raw")
                .addColumn("smart_183")
                .addColumn("smart_183_raw")
                .addColumn("smart_184")
                .addColumn("smart_184_raw")
                .addColumn("smart_187")
                .addColumn("smart_187_raw")
                .addColumn("smart_188")
                .addColumn("smart_188_raw")
                .addColumn("smart_189")
                .addColumn("smart_189_raw")
                .addColumn("smart_190")
                .addColumn("smart_190_raw")
                .addColumn("smart_191")
                .addColumn("smart_191_raw")
                .addColumn("smart_192")
                .addColumn("smart_192_raw")
                .addColumn("smart_193")
                .addColumn("smart_193_raw")
                .addColumn("smart_194")
                .addColumn("smart_194_raw")
                .addColumn("smart_195")
                .addColumn("smart_195_raw")
                .addColumn("smart_196")
                .addColumn("smart_196_raw")
                .addColumn("smart_197")
                .addColumn("smart_197_raw")
                .addColumn("smart_198")
                .addColumn("smart_198_raw")
                .addColumn("smart_199")
                .addColumn("smart_199_raw")
                .addColumn("smart_200")
                .addColumn("smart_200_raw")
                .addColumn("smart_201")
                .addColumn("smart_201_raw")
                .addColumn("smart_218")
                .addColumn("smart_218_raw")
                .addColumn("smart_220")
                .addColumn("smart_220_raw")
                .addColumn("smart_222")
                .addColumn("smart_222_raw")
                .addColumn("smart_223")
                .addColumn("smart_223_raw")
                .addColumn("smart_224")
                .addColumn("smart_224_raw")
                .addColumn("smart_225")
                .addColumn("smart_225_raw")
                .addColumn("smart_226")
                .addColumn("smart_226_raw")
                .addColumn("smart_231")
                .addColumn("smart_231_raw")
                .addColumn("smart_232")
                .addColumn("smart_232_raw")
                .addColumn("smart_233")
                .addColumn("smart_233_raw")
                .addColumn("smart_235")
                .addColumn("smart_235_raw")
                .addColumn("smart_240")
                .addColumn("smart_240_raw")
                .addColumn("smart_241")
                .addColumn("smart_241_raw")
                .addColumn("smart_242")
                .addColumn("smart_242_raw")
                .addColumn("smart_250")
                .addColumn("smart_250_raw")
                .addColumn("smart_251")
                .addColumn("smart_251_raw")
                .addColumn("smart_252")
                .addColumn("smart_252_raw")
                .addColumn("smart_254")
                .addColumn("smart_254_raw")
                .addColumn("smart_255")
                .addColumn("smart_255_raw")
                .build();
    }

}
