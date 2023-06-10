package com.example.Library.controllers;

import com.example.Library.model.Book;
import com.example.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DefaultController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Book> bookIterable = bookRepository.findAll();
        List<Book> books = new ArrayList<>();
        for (Book book : bookIterable) {
            books.add(book);
        }

        model.addAttribute("books", books);
        model.addAttribute("bookCounts",books.size());

        return "index";
    }
}
