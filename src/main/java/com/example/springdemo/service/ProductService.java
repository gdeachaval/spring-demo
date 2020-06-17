package com.example.springdemo.service;

import com.example.springdemo.dto.BookDTO;
import com.example.springdemo.model.Book;
import com.example.springdemo.model.BookNotFoundException;
import com.example.springdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Book getBook(String title) {
        final Book book = productRepository.findByTitle(title);

        if (book == null) throw new BookNotFoundException();

        return book;
    }

    public Book saveBook(BookDTO bookDTO) {
        final Book book = new Book(bookDTO.getTitle(), bookDTO.getIsbn());
        return productRepository.save(book);
    }
}
