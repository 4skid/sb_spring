package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.data.book.Author;
import com.example.MyBookShopApp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Map<String, List<Author>> getAuthorsMap() {
        Map<String, List<Author>> map = new HashMap<>();
        List<Author> authors = authorRepository.findAll();
        for (Author author : authors) {
            String firstLetter = author.getName().substring(0, 1).toUpperCase(Locale.ROOT);
            if (!map.containsKey(firstLetter)) {
                map.put(firstLetter, new ArrayList<>());
            }
            map.get(firstLetter).add(author);
        }
        return map;
    }

}
