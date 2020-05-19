package com.example.demo.components;

import com.example.demo.controller.KafkaController;
import com.example.demo.service.ProducerService;
import com.example.demo.service.TwitterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import twitter4j.TwitterException;

@Component
public class DataFetcherComponent {

    private static Logger log = LoggerFactory.getLogger(DataFetcherComponent.class);
    private final TwitterService twitterService;
    private final ProducerService producerService;

    public DataFetcherComponent(TwitterService twitterService, ProducerService producerService) {
        this.twitterService = twitterService;
        this.producerService = producerService;
    }

    @Scheduled(fixedRate = 100000)
    public void pollData() throws TwitterException {
        log.info("polling twitter");

        var tweets = twitterService.searchTweets();

        log.info("Retrieved {} tweets", tweets.size());

        tweets.forEach(tweet -> producerService.publishMessage(tweet));
    }
}


