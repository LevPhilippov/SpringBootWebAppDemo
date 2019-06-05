package com.filippov.SpringBootWebAppDemo.controllers;

import com.filippov.SpringBootWebAppDemo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String fetAuthors(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }
}
