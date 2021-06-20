package com.codegym.demo.service.impl;

import com.codegym.demo.model.Article;
import com.codegym.demo.model.Category;
import com.codegym.demo.repository.ArticleRepository;
import com.codegym.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void remove(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Iterable<Article> findAllByCategory(Category category) {
        return articleRepository.findAllByCategory(category);
    }

    @Override
    public Page<Article> findAllByTitleContaining(String title, Pageable pageable) {
        return articleRepository.findAllByTitleContaining(title, pageable);
    }
}
