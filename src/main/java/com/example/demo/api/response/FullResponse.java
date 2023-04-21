package com.example.demo.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class FullResponse {
    private Integer id;

    private String title;

    private LocalDateTime dateAndTimeOfPublication;
}
