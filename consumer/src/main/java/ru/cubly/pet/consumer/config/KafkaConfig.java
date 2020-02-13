package ru.cubly.pet.consumer.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.cubly.pet.model.HddReport;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfig {
    public static final String KAFKA_SERVICE_ID = "kafka";
    public static final String GROUP_ID = "hddReport-consumer";

    @Value("${hdd.consumer.kafkaTopic}")
    private String hddReportTopic = "hddReport";

    private final DiscoveryClient discoveryClient;

    public KafkaConfig(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Bean
    public MessageListenerContainer messageListenerContainer(
            ContainerProperties containerProps,
            ConsumerFactory<String, HddReport> kafkaListenerContainerFactory,
            MessageListener<String, HddReport> messageListener) {

        ConcurrentMessageListenerContainer<String, HddReport> container =
                new ConcurrentMessageListenerContainer<>(kafkaListenerContainerFactory, containerProps);

        container.setupMessageListener(messageListener);

        return container;
    }

    @Bean
    public ConsumerFactory<String, HddReport> kafkaListenerContainerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public ContainerProperties containerProperties() {
        return new ContainerProperties(hddReportTopic);
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, getBrokersAsString());

        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        props.put(JsonDeserializer.TRUSTED_PACKAGES, "ru.cubly.pet.model");

        props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);

        return props;
    }

    private String getBrokersAsString() {
        return discoveryClient.getInstances(KAFKA_SERVICE_ID)
                .stream()
                .map(si -> si.getHost() + ":" + si.getPort())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Kafka service is not found in consul"));
    }
}
