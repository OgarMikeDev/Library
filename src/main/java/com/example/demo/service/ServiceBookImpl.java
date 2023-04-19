//package com.example.demo.service;
//
//import com.example.demo.model.Book;
//import com.example.demo.repository.BookRepository;
//import com.example.demo.api.request.Request;
//import com.example.demo.api.response.Response;
//import lombok.RequiredArgsConstructor;
//
//@RequiredArgsConstructor
//public class ServiceBookImpl implements ServiceBook {
//    private final BookRepository repository;
//    @Override
//    public Response add(Request request) {
//        Book book = new Book();
//        book.setTitle(request.getTitle());
//        repository.save(book);
//        return new Response(book.isVarIsPublic());
//    }
//
////    @Override
////    public String getById(String id) {
////        return " ";
////    }
//}
