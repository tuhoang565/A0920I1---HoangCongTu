package com.demo.service.impl;

import com.demo.model.Book;
import com.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    private static Map<Long, Book> bookMap;
    static {
        bookMap = new HashMap<>();
        bookMap.put(1L, new Book(1L, "Nha gia kim", 3));
        bookMap.put(2L, new Book(2L, "Campus", 4));
        bookMap.put(3L, new Book(3L, "Cambridge", 2));
        bookMap.put(4L, new Book(4L, "Window", 1));
    }


    @Override
    public Book findById(Long id) {
        return bookMap.get(id);
    }

    @Override
    public void save(Book book) {
        bookMap.put(book.getId(), book);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookMap.values());
    }

    @Override
    public void update(Long id, Book book) {

    }

    @Override
    public void delete(Long id) {

    }



}
