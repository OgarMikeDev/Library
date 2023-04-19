package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.request.Request;
//import com.example.demo.service.ServiceBook;
import com.example.demo.response.Response;
import com.example.demo.service.ServiceBook;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookRestController {

    @Autowired(required = true)
    private ServiceBook service;


    @PostMapping("/")
    private Response addBook(@RequestBody Request request) {
        return service.add(request);
    }


//    @GetMapping("/{id}")
//    private Book getBooks(@PathVariable String id) {
//        return repository.getById(id);
//    }
}