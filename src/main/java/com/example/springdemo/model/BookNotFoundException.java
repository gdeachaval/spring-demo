package com.example.springdemo.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Requested book not found")
public class BookNotFoundException extends RuntimeException {
}
