package com.example.exemple.jdbc.repository;

import com.example.exemple.jdbc.model.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
@Repository
public class MessageWriteRepository {
    private static final String INSERT_SQL = "insert into message (id, name, idade) values (:id,:name,:idade);";

    private final NamedParameterJdbcTemplate jdbcTemplate;


    public MessageWriteRepository(@Qualifier("rwJdbcTemplate") final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Message persist(final Message message) {
        final UUID id = UUID.randomUUID();
        final Map<String, ?> parameters = Map.of(
                "id", id,
                "name", message.getName(),
                "idade", message.getIdade());

        final int updated = this.jdbcTemplate.update(INSERT_SQL, parameters);

        if (updated > 0) {
            message.setId(id.toString());
        }

        return message;
    }
}
