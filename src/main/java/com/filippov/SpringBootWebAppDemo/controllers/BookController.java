package com.filippov.SpringBootWebAppDemo.controllers;

import com.filippov.SpringBootWebAppDemo.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //аннотация помечает класс как Spring-Bean
public class BookController {
    BookRepository bookRepository;

    //наличие непустого конструктора обязательно для автоматического создания объекта Spring и его привязки (без этого не работает)
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @RequestMapping("/books") //аннотация сообщает Spring выполнить этот метод при получении Request (/books)
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }
}
