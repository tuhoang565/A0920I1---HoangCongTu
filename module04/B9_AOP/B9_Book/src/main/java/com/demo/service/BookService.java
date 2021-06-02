package com.demo.service;

import com.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);
    Book findById(Long id);
    void save(Book book);
    Page<Book> findAllByName(String name, Pageable pageable);
    void borrow(Long id);
}
