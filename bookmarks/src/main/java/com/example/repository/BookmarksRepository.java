package com.example.repository;

import com.example.domain.Bookmark;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BookmarksRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<Bookmark> bookmarkRowMapper;

    public BookmarksRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.bookmarkRowMapper = (rs, i)->new Bookmark(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("tag"),
                rs.getString("type"));
    }

    public List<Bookmark> findAll() {
        return jdbcTemplate.query("SELECT * FROM readlater WHERE type = 'readlater'", bookmarkRowMapper);
    }

    public List<Bookmark> findReadAll() {
        return jdbcTemplate.query("SELECT * FROM readlater WHERE type = 'read'", bookmarkRowMapper);
    }

    public void addBookmark (Bookmark bookmark){
        jdbcTemplate.update("INSERT INTO readlater (name, description, tag, type) VALUES (:name, :description, :tag, 'readlater')", Map.of("name", bookmark.getName(), "description", bookmark.getDescription(),
                "tag", bookmark.getTag()));
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM readlater WHERE id = :id", Map.of("id", id));
    }


    public List<Bookmark> findAllBookmarks() {
        return jdbcTemplate.query("SELECT * FROM readlater",bookmarkRowMapper);
    }
    public void sendInRead(int id){
        jdbcTemplate.update("UPDATE readlater SET type = 'read' WHERE id =:id",Map.of("id", id));
    }

    public void sendInReadLater(int id){
        jdbcTemplate.update("UPDATE readlater SET type = 'readlater' WHERE id= :id", Map.of("id", id));
    }
}
