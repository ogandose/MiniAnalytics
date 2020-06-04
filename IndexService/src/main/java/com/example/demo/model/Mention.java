package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;


@SolrDocument(collection = "mention")
public class Mention {

    @Id
    @Indexed(name = "id", type = "string")
    private String id;

    @Indexed(name = "username", type = "string")
    private String username;

    @Indexed(name = "snippet", type = "string")
    private String snippet;

}
