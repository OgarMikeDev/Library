package com.example.Library.controllers;

import com.example.Library.model.Book;
import com.example.Library.repository.BookRepository;
import com.example.Library.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books/")
    public List<Book> getBooks() {
        Iterable<Book> bookIterable = bookRepository.findAll();
        List<Book> bookList = new ArrayList<>();
        for (Book book : bookIterable) {
            bookList.add(book);
        }
        return bookList ;
    }

    @PostMapping("/books/")
    public int add(Book book) {
        Book newBook = bookRepository.save(book);
        return newBook.getId();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity getBook(@PathVariable int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = optionalBook.get();
        if (optionalBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity(book, HttpStatus.OK);
    }
}
