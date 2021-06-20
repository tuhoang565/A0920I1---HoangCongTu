package com.demo.service.impl;

import com.demo.model.Book;
import com.demo.model.Lending;
import com.demo.repository.BookRepository;
import com.demo.repository.LendingRepository;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private LendingRepository lendingRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
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
    public void borrow(Book book, Lending lending) {
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
        lendingRepository.save(lending);
    }

    @Override
    public void returnBook(int idLending) {
        Iterable<Lending> lendingList = lendingRepository.findAll();
        Iterable<Book> bookList = bookRepository.findAll();
        boolean flag = false;
        while (lendingList.iterator().hasNext()) {
            if ((lendingList.iterator().next().getIdLending()) == idLending) {
                flag = true;
                break;
            }
        }

        if (flag == true) {
            Book book = bookList.;
        }
    }
}
