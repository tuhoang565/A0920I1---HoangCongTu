package com.demo.controller;

import com.demo.model.Book;
import com.demo.model.Lending;
import com.demo.repository.BookRepository;
import com.demo.service.BookService;
import com.demo.service.LendingService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.Random;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private LendingService lendingService;

    @GetMapping("/create-book")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/create-book")
    public ModelAndView createBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", book);
        modelAndView.addObject("message","New book was added sucessful");
        return modelAndView;
    }

    @GetMapping("/books")
    public ModelAndView listBooks(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<Book> books;
        if(s.isPresent()){
            books = bookService.findAllByName(s.get(), pageable);
        }else {
            books = bookService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/borrow-book/{id}")
    public ModelAndView borrowBookForm(@PathVariable Long id){
        Random random = new Random();
        int upper = 99999;
        int int_random = (random.nextInt(upper));

        Book book = bookService.findById(id);


        if(book != null) {
            ModelAndView modelAndView = new ModelAndView("/book/borrow");
            modelAndView.addObject("book", book);
            
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/borrow-book")
    public String borrowBook(@ModelAttribute("book") Book book){
        bookService.borrow(book.getId());
        return "redirect:books";
    }
}
