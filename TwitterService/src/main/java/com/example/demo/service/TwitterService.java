package com.example.demo.service;

import com.example.demo.model.Mention;
import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TwitterService {

    private Twitter getTwitterInstance() {
        return TwitterFactory.getSingleton();
    }

    public List<Mention> searchTweets() throws TwitterException {
        Twitter twitter = getTwitterInstance();
        Query query = new Query("Stuttgart");
        QueryResult result = twitter.search(query);
        List<Status> statuses = result.getTweets();
        return statuses.stream().map(
                item -> {
                   return new Mention(item.getUser().getScreenName(), item.getText());
                }).collect(
                Collectors.toList());
    }
}

