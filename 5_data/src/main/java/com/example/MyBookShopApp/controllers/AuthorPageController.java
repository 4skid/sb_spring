package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.book.Author;
import com.example.MyBookShopApp.service.AuthorService;
import com.example.MyBookShopApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
public class AuthorPageController {

    private final AuthorService authorService;
    private final BookService bookService;
    @Autowired
    public AuthorPageController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap() {
        return authorService.getAuthorsMap();
    }


    @GetMapping("/authors")
    public String authorsPage() {
        return "/authors/index";
    }
}
