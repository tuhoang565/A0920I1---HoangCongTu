package com.demo.service.impl;

import com.demo.model.Book;
import com.demo.repository.BookRepository;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }


    @Override
    public Page<Book> findAllByName(String name, Pageable pageable) {
        return bookRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public void borrow(Long id) {
        //Random number
        Random random = new Random();
        int upper = 99999;
        int int_random = (random.nextInt(upper));
        Book book = bookRepository.findById(id).orElse(null);

        bookRepository.borrowBook(book.getQuantity(), int_random);

    }
}
