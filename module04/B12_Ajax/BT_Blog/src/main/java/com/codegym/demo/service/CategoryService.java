package com.codegym.demo.service;

import com.codegym.demo.model.Category;
import org.springframework.stereotype.Service;


public interface CategoryService {
    Iterable<Category> findAll();
    Category findById(Long id);
    void save(Category category);
    void remove(Long id);
}
