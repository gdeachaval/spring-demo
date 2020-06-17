package com.example.springdemo.repository;

import com.example.springdemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
}
