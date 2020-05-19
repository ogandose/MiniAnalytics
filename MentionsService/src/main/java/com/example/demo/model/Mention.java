package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Mention {
    private  String snippet;
    private  String username;
    private final UUID id;

    public Mention(@JsonProperty("id") UUID id, @JsonProperty("userName") String userName, @JsonProperty("snippet") String snippet) {
        this.username = userName;
        this.snippet = snippet;
        this.id = id;
    }

    public String getSnippet() {
        return snippet;
    }

    public String getUsername() {
        return username;
    }

    public UUID getID() { return id;}
}
