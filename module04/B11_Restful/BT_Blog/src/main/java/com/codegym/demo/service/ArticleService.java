package com.codegym.demo.service;

import com.codegym.demo.model.Article;
import com.codegym.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {
    List<Article> getAll();
    Page<Article> findAll(Pageable pageable);
    Article findById(Long id);
    void save(Article article);
    void remove(Long id);
    Iterable<Article> findAllByCategory(Category category);
    Page<Article> findAllByTitleContaining(String title, Pageable pageable);
}
