package com.example.demo.service;

import com.example.demo.model.Mention;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private KafkaTemplate<String, Mention> KafkaJsonTemplate;

    public ProducerService(KafkaTemplate<String, Mention> kafkaJsonTemplate) {
        KafkaJsonTemplate = kafkaJsonTemplate;
    }

    public void publishMessage(Mention mention) {
        KafkaJsonTemplate.send("myTopic", mention);
    }
}
