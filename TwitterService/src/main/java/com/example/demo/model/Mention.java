package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Mention {
    private  String snippet;
    private  String username;

    public Mention(@JsonProperty("userName") String userName, @JsonProperty("snippet") String snippet) {
        this.username = userName;
        this.snippet = snippet;
    }

    public String getSnippet() {
        return snippet;
    }

    public String getUsername() {
        return username;
    }




}
