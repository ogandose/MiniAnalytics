package com.example.demo.configuration;

import com.example.demo.model.Mention;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConsumerConfiguration {

    @Value("${kafka.broker}")
    private String KAFKA_BROKER = "localhost:9092";
    private static final String GROUP_ID = "kafka-sandbox";

    @Bean
    public ConsumerFactory<String, Mention> consumerFactory() {
        return new DefaultKafkaConsumerFactory<String, Mention>(consumerConfigurations(), new StringDeserializer(), new JsonDeserializer<>(Mention.class));
    }

    @Bean
    public Map<String, Object> consumerConfigurations() {
        Map<String, Object> configurations = new HashMap<>();

        configurations.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKER);
        configurations.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        configurations.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configurations.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return configurations;
    }
    @Bean
    ConcurrentKafkaListenerContainerFactory<String, Mention> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Mention> factory = new ConcurrentKafkaListenerContainerFactory<String, Mention>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
