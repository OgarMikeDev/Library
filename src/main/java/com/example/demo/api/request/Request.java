package com.example.demo.api.request;

import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class Request {
    private String title;

    private Integer yearOfIssue;

}
