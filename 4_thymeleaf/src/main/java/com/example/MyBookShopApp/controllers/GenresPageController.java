package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenresPageController {

    private final GenresService genresService;

    @Autowired
    public GenresPageController(GenresService genresService) {
        this.genresService = genresService;
    }

    @GetMapping("/genres")
    public String genresPage() {
        return "genres/index";
    }
}
