package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.data.genre.GenreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class GenresService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GenresService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<GenreEntity> getGenresDate() {
        List<GenreEntity> genres = jdbcTemplate.query("SELECT * FROM genres", (ResultSet rs, int rowNum) -> {
            GenreEntity genre = new GenreEntity();
            genre.setId(rs.getInt("id"));
            genre.setName(rs.getString("name"));
            genre.setSlug(rs.getString("slug"));
            genre.setParentId(rs.getInt("parentId"));
            return genre;
        });
        return null;
    }
}
