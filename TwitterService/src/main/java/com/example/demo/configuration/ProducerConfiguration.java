package com.example.demo.configuration;

import com.example.demo.model.Mention;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfiguration {

    @Value("${kafka.broker:localhost:9092}")
    private String KAFKA_BROKER = "localhost:9092";

    @Bean
    public ProducerFactory<String, Mention> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigurations());
    }

    @Bean
    public Map<String, Object> producerConfigurations() {
        Map<String, Object> configurations = new HashMap<>();

        configurations.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKER);
        configurations.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configurations.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return configurations;
    }

    @Bean
    public KafkaTemplate<String, Mention> kafkaTemplate(){
        return new KafkaTemplate<String, Mention>(producerFactory());
    }

}
