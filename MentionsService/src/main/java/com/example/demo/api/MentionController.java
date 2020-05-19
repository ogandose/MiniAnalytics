package com.example.demo.api;

import com.example.demo.model.Mention;
import com.example.demo.service.MentionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/mention")
@RestController
public class MentionController {
    private final MentionsService mentionsService;

    @Autowired
    public MentionController(MentionsService mentionsService) {
        this.mentionsService = mentionsService;
    }

    @PostMapping
    public void addMention(@Valid @NotNull @RequestBody Mention mention) {
        mentionsService.addMention(mention);
    }

    @GetMapping
    public List<Mention> getAllMentions() {
        return mentionsService.getAllMentions();
    }

    @GetMapping(path = "{id}")
    public Mention getMentionById(@PathVariable("id") UUID id) {
        return mentionsService.getMentionById(id)
                .orElse(null);
    }
}
