package com.codegym.controller;

import com.codegym.model.Dictionary;
import com.codegym.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/home")
    public String home(){
        return "dictionaries/home.jsp";
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam("keySearch") String keySearch, ModelAndView modelAndView){
        Dictionary dictionary = dictionaryService.findOne(keySearch);
        modelAndView.addObject("dictionary", dictionary);
        return modelAndView;
    }

}
