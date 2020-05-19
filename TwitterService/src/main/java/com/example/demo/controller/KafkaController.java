package com.example.demo.controller;

import com.example.demo.consumer.MyTopicConsumer;
import com.example.demo.model.Mention;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KafkaController {

    private KafkaTemplate<String, Mention> KafkaJsontemplate;
    private MyTopicConsumer myTopicConsumer;

    public KafkaController(KafkaTemplate<String, Mention> kafkaJsontemplate, MyTopicConsumer myTopicConsumer) {
        KafkaJsontemplate = kafkaJsontemplate;
        this.myTopicConsumer = myTopicConsumer;
    }

    @PostMapping(value = "/postItem",consumes = {"application/json"},produces = {"application/json"})
    public void produce(@RequestParam Mention mention) {
        KafkaJsontemplate.send("myTopic", mention);
    }

    @GetMapping("/kafka/messages")
    public List<Mention> getMessages() {
        return myTopicConsumer.getMessages();
    }
}

