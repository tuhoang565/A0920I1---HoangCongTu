package com.codegym.controller;

import com.codegym.model.Article;
import com.codegym.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/create-article")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/article/create");
        modelAndView.addObject("article", new Article());
        return modelAndView;
    }
    @PostMapping("create-article")
    public ModelAndView saveArticle(@ModelAttribute("article") Article article){
        articleService.save(article);
        ModelAndView modelAndView = new ModelAndView("/article/create");
        modelAndView.addObject("article", new Article());
        modelAndView.addObject("message", "New article created successfully");
        return modelAndView;
    }

    @GetMapping("articles")
    public ModelAndView listArticles(){
        List<Article> articles = articleService.findAll();
        ModelAndView modelAndView = new ModelAndView("/article/list");
        modelAndView.addObject("articles", articles);
        return modelAndView;
    }

    @GetMapping("/edit-article/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Article article = articleService.findById(id);
        if(article != null){
            ModelAndView modelAndView = new ModelAndView("/article/edit");
            modelAndView.addObject("article", article);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-article")
    public ModelAndView updateArticle(@ModelAttribute("article") Article article){
        articleService.save(article);
        ModelAndView modelAndView = new ModelAndView("/article/edit");
        modelAndView.addObject("article", article);
        modelAndView.addObject("message", "Article updated successfully");
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
}
