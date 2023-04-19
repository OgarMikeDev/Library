package com.example.demo.controller;

import com.example.demo.api.request.Request;
//import com.example.demo.service.ServiceBook;
import com.example.demo.api.response.Response;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
//import com.example.demo.service.ServiceBook;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController {

    private final BookRepository repository;


    @PostMapping("/")
    private Response addBook(@RequestBody Request request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        repository.save(book);
        return new Response(book.getId(), book.getTitle());
    }


    @GetMapping("/{id}")
    private Book getBooks(@PathVariable String id) {
        return repository.getById(id);
    }
}