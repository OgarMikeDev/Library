package com.example.Library.controllers;

import com.example.Library.model.Book;
import com.example.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DefaultController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Book> bookIterable = bookRepository.findAll();
        List<Book> bookList = new ArrayList<>();
        for (Book book : bookIterable) {
            bookList.add(book);
        }

        model.addAttribute("books", bookList);
        model.addAttribute("bookCounts", bookList.size());

        return "index";
    }

    @RequestMapping("/specificBook")
    public String getSpecificBook(Model modelBook) {
        Iterable<Book> iterable = bookRepository.findAll();
        List<Book> bookList = new ArrayList<>();
        for (Book book : iterable) {
            bookList.add(book);
        }

        modelBook.addAttribute("specificBookId", bookList.get(1).getId());
        modelBook.addAttribute("specificBookName", bookList.get(1).getName());
        modelBook.addAttribute("specificBookYear", bookList.get(1).getYear());
        
        return "specificBook";
    }
}
