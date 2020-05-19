package com.example.demo.service;

import com.example.demo.controller.KafkaController;
import com.example.demo.model.Mention;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final KafkaController kafkaController;

    public ProducerService(KafkaController kafkaController) {
        this.kafkaController = kafkaController;
    }

    public void publishMessage(Mention mention) {
        kafkaController.produce(mention);
    }




}
