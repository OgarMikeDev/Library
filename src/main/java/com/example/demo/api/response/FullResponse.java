package com.example.demo.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class FullResponse {
    Integer id;

    String title;

    LocalDateTime dateTime;
}
