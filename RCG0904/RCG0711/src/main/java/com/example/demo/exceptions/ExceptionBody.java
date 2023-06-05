package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class ExcepcionBody {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
    private String path;
}