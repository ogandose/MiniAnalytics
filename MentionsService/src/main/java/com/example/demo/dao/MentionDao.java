package com.example.demo.dao;

import com.example.demo.model.Mention;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MentionDao {

    int insertMention(UUID id, Mention mention);

    default int insertMention(Mention mention) {
        UUID id = UUID.randomUUID();
        return insertMention(id, mention);
    }

    List<Mention> selectAllMentions();

    Optional<Mention> selectMentionById(UUID id);

    int deleteMentionById(UUID id);

    int updateMentionById(UUID id, Mention mention);
}
