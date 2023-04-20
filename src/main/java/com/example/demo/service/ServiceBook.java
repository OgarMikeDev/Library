package com.example.demo.service;

import com.example.demo.api.request.Request;
import com.example.demo.api.response.Response;
import org.springframework.stereotype.Service;

@Service
public interface ServiceBook {
    Response add(Request request);
}
