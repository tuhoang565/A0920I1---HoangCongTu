package com.demo.service;

import com.demo.model.Book;

import java.util.List;

public interface BookService {

    Book findById(Long id);
    void save(Book book);

    List<Book> findAll();
    void update(Long id, Book book);
    void delete(Long id);

}
