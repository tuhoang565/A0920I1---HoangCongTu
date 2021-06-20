package com.codegym.demo.controller;

import com.codegym.demo.model.Article;
import com.codegym.demo.model.Category;
import com.codegym.demo.service.ArticleService;
import com.codegym.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;

//    get all category
    @GetMapping(value = "/api/category")
    public ResponseEntity<List<Category>> listAllCategory(){
        List<Category> categories = categoryService.getAll();
        if(categories.isEmpty()){
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

//    get all article
    @GetMapping(value = "/api/article")
    public ResponseEntity<List<Article>> listAllArticle(){
        List<Article> articles = articleService.getAll();
        if(articles.isEmpty()){
            return new ResponseEntity<List<Article>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
    }

//    get all article by category
    @GetMapping(value = "/api/article-by-category/{id}")
    public ResponseEntity<Iterable<Article>> getAllArticleByCategory(@PathVariable("id") Long id){
        Category category = categoryService.findById(id);
        Iterable<Article> articles = articleService.findAllByCategory(category);
        if((articles.iterator().hasNext())){
            return new ResponseEntity<Iterable<Article>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Iterable<Article>>(articles, HttpStatus.OK);
    }
}
