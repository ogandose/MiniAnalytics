package com.example.demo.consumer;

import com.example.demo.model.Mention;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyTopicConsumer {

    private final List<Mention> messages = new ArrayList<>();

    @KafkaListener(topics = "myTopic", groupId = "kafka-sandbox")
    public void listen(Mention message) {
        synchronized (messages) {
            messages.add(message);
        }
    }

    public List<Mention> getMessages() {
        return messages;
    }

}