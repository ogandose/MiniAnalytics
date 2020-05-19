package com.example.demo.dao;

import com.example.demo.model.Mention;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresdb")
public class MentionDataAccessService implements MentionDao {

    private final JdbcTemplate jdbcTemplate;

    public MentionDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertMention(UUID id, Mention mention) {
        return jdbcTemplate.update(
                "INSERT INTO mentions (id, snippet, username) VALUES (?, ?, ?)",
                id, mention.getSnippet(), mention.getUsername()
        );
    }

    @Override
    public List<Mention> selectAllMentions() {
        final String sql="SELECT id, snippet, username FROM mentions";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String snippet = resultSet.getString("snippet");
            String username = resultSet.getString("username");
            return new Mention(id, snippet, username);
        });
    }

    @Override
    public Optional<Mention> selectMentionById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteMentionById(UUID id) {
        return 0;
    }

    @Override
    public int updateMentionById(UUID id, Mention mention) {
        return 0;
    }
}
