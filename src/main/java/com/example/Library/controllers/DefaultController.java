package com.example.Library.controllers;

import com.example.Library.model.Book;
import com.example.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/specificBookPage")
    public String getSpecificBook(Book book, Model model) {
        System.out.println("Book name, input at form for open specific book '" + book.getName() + "'.\nYear book '" + book.getYear() + "'.");
        Iterable<Book> optionalBook = bookRepository.findAll();
        Book updateBook = new Book();
        for (Book currentBook : optionalBook) {
            if (currentBook.getName().equals(book.getName())) {
                System.out.println("Find book in the library! Her Name '" + currentBook.getName() + "'.");
                updateBook = currentBook;
                break;
            }
            System.out.println(currentBook);
        }

        System.out.println("Name book '" + updateBook.getName() + "'.\nYear book '" + updateBook.getYear() + "'.");
        model.addAttribute("specificBookId", updateBook.getId());
        model.addAttribute("specificBookName", updateBook.getName());
        model.addAttribute("specificBookYear", updateBook.getYear());

        return "specificBook";
    }
}
