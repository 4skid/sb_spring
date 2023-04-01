package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.*;

@Service
public class AuthorService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Set<Author>> getAuthorsData() {
        Map<String, Set<Author>> mapByLetter = new HashMap<>();
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int numRow) -> {
        Author author = new Author();
        author.setId(rs.getInt("id"));
        author.setFirstName(rs.getString("first_name"));
        author.setLastName(rs.getString("last_name"));
        return author;
        });
        for (Author author : authors) {
            String lastName = author.getLastName();
            String firstLetter = String.valueOf(lastName.charAt(0));
            if(!mapByLetter.containsKey(firstLetter)){
                mapByLetter.put(firstLetter, new TreeSet<>());
            }
            mapByLetter.get(firstLetter).add(author);
        }
        return new HashMap<>(mapByLetter);
    }

}
