package com.example.springdemo.controller;

import com.example.springdemo.dto.BookDTO;
import com.example.springdemo.model.Book;
import com.example.springdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/book")
    public ResponseEntity<Book> getBook(@RequestParam String title) {
        final Book body = productService.getBook(title);
        final HttpStatus status = HttpStatus.OK;

        return new ResponseEntity<>(body, status);
    }

    @PostMapping(value = "/book")
    public ResponseEntity<Book> postBook(@RequestBody BookDTO bookDTO) {
        final Book body = productService.saveBook(bookDTO);
        final HttpStatus status = HttpStatus.CREATED;

        return new ResponseEntity<>(body, status);
    }
}
