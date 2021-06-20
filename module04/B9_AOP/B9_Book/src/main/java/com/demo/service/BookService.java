package com.demo.service;

import com.demo.model.Book;
import com.demo.model.Lending;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    void save(Book book);
    Page<Book> findAllByName(String name, Pageable pageable);
    void borrow(Book book, Lending lending);
    void returnBook(int idLending);
}
