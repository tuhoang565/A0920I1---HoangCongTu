package com.codegym.demo.controller;

import com.codegym.demo.model.Article;
import com.codegym.demo.model.Category;
import com.codegym.demo.service.ArticleService;
import com.codegym.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/create-article")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/article/create");
        modelAndView.addObject("article", new Article());
        return modelAndView;
    }

    @PostMapping("/create-article")
    public ModelAndView saveArticle(Article article){
        articleService.save(article);
        ModelAndView modelAndView = new ModelAndView("/article/create");
        modelAndView.addObject("article", new Article());
        modelAndView.addObject("message", "New article added successful");
        return modelAndView;
    }

    @GetMapping("/articles")
    public ModelAndView showArticle(@RequestParam("s") Optional<String> s, Pageable pageable){
        int pageNumber = pageable.getPageNumber();
        int page = pageNumber * 20;
        System.out.println(page);
        Page<Article> articles;
        if(s.isPresent()){
            articles = articleService.findAllByTitleContaining(s.get(), PageRequest.of(0, page));
        }else {
            articles = articleService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/article/list");
        modelAndView.addObject("articles", articles);
        return modelAndView;
    }

    @GetMapping("/edit-article/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Article article = articleService.findById(id);
        if(article != null) {
            ModelAndView modelAndView = new ModelAndView("/article/edit");
            modelAndView.addObject("article", article);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-article")
    public ModelAndView updateArticle(Article article){
        articleService.save(article);
        ModelAndView modelAndView = new ModelAndView("/article/edit");
        modelAndView.addObject("article", article);
        modelAndView.addObject("message", "Update successful");
        return modelAndView;
    }

    @GetMapping("/delete-article/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Article article = articleService.findById(id);
        if(article != null){
            ModelAndView modelAndView = new ModelAndView("/article/delete");
            modelAndView.addObject("article", article);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-article")
    public String deleteArticle(@ModelAttribute("article") Article article){
        articleService.remove(article.getId());
        return "redirect:articles";
    }

    @GetMapping("/search")
    public String searchByTitle(@RequestParam(value = "search", required = false) String search, Model model,Pageable pageable){
        Page<Article> articles;
        if(search != null && !search.equals("")){
            articles = articleService.findAllByTitleContaining(search, pageable);
        }else {
            articles = articleService.findAll(pageable);
        }
        model.addAttribute("articles", articles);
        return "article/search";
    }
}
