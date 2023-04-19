package com.example.demo.service;

import com.example.demo.request.Request;
import com.example.demo.response.Response;
import org.springframework.stereotype.Service;

@Service
public interface ServiceBook {
    Response add(Request request);


//    String getById(String id);
}
