package com.example.demo.service;

import com.example.demo.api.response.FullResponse;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.api.request.Request;
import com.example.demo.api.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ServiceBookImpl implements ServiceBook {
    private final BookRepository repository;
    @Override
    public Response add(Request request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setDateAndTimeOfPublication(LocalDateTime.now());
        repository.save(book);
        return new Response(book.getId(), book.getTitle());
    }

    @Override
    public FullResponse getBookById(String id) {
        return repository.getBookById(Integer.parseInt(id));
    }
}
