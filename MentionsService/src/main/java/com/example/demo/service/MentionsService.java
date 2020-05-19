package com.example.demo.service;

import com.example.demo.dao.MentionDao;
import com.example.demo.model.Mention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MentionsService {

    private final MentionDao mentionDao;

    @Autowired
    public MentionsService(@Qualifier("postgresdb") MentionDao mentionDao) {this.mentionDao = mentionDao; }

    public int addMention(Mention mention) {
        return mentionDao.insertMention(mention);
    }

    public List<Mention> getAllMentions() {
        return mentionDao.selectAllMentions();
    }

    public Optional<Mention> getMentionById(UUID id) {
        return mentionDao.selectMentionById(id);
    }
}