package com.example.Library.controllers;

import com.example.Library.model.Book;
import com.example.Library.storage.Storage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/books/")
    public List<Book> getBooks() {
        return Storage.getAllBooks();
    }

    @PostMapping("/books/")
    public int add(Book book) {
        return Storage.addBook(book);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity getBook(@PathVariable int id) {
        Book book = Storage.getBook(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity(book, HttpStatus.OK);
    }
}

