package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController {

    private final BookRepository repository;


    @PostMapping
    private Book setBook(@RequestBody Book book) {

        return book;
    }


    @GetMapping("/all")
    private List<Book> getBooks() {
        return repository.findAll();
    }
}