package com.codegym.demo.repository;

import com.codegym.demo.model.Article;
import com.codegym.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Iterable<Article> findAllByCategory(Category category);
    Page<Article> findAllByTitleContaining(String title, Pageable pageable);
}
