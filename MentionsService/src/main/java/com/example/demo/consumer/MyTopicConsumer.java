package com.example.demo.consumer;

import com.example.demo.model.Mention;
import com.example.demo.service.MentionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MyTopicConsumer {

    private final MentionsService mentionsService;
    private static Logger log = LoggerFactory.getLogger(MyTopicConsumer.class);

    public MyTopicConsumer(MentionsService mentionsService) {
        this.mentionsService = mentionsService;
    }

    @KafkaListener(topics = "myTopic", groupId = "kafka-sandbox")
    public void listen(Mention message) {
            log.info("received message {}", message.getSnippet());
            mentionsService.addMention(new Mention(UUID.randomUUID(), message.getUsername(), message.getSnippet()));

    }
}