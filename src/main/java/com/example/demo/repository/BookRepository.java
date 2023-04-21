package com.example.demo.repository;

import com.example.demo.api.response.FullResponse;
import com.example.demo.api.response.Response;
import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    FullResponse getBookById(Integer id);
}
