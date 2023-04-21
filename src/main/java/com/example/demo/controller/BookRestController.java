package com.example.demo.controller;

import com.example.demo.api.request.Request;
//import com.example.demo.service.ServiceBook;
import com.example.demo.api.response.FullResponse;
import com.example.demo.api.response.Response;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
//import com.example.demo.service.ServiceBook;
import com.example.demo.service.ServiceBook;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController {

    private final ServiceBook service;


    @PostMapping("/")
    private Response addBook(@RequestBody Request request) {
        return service.add(request);
    }


    @GetMapping("/{id}")
    private FullResponse getBooks(@PathVariable String id) {
        return service.getBookById(String.valueOf(id));
    }
}