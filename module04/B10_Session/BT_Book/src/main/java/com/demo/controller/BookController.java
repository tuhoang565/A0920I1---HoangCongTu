package com.demo.controller;

import com.demo.model.Book;

import com.demo.service.BookService;
import com.demo.service.impl.BookServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@SessionAttributes("mybook")
public class BookController {
    @Autowired
    private BookService bookService;

    @ModelAttribute("mybook")
    public Book setUpBook() {
        return new Book();
    }

    @GetMapping("/books")
    public ModelAndView listBook() {
        List<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("/book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/create-book")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/create-book")
    public ModelAndView saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("customer", new Book());
        modelAndView.addObject("message", "New book was added successful");
        return modelAndView;
    }


    @GetMapping("/view-detail/{id}")
    public ModelAndView viewDetail(@PathVariable("id") Long id, @ModelAttribute("book") Book book){
        book = bookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/book/detail");
        modelAndView.addObject("book", book);
        return modelAndView;
    }


}
