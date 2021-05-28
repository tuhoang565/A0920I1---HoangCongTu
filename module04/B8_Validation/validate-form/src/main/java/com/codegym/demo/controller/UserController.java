package com.codegym.demo.controller;

import com.codegym.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;

@Controller
public class UserController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/")
    public String checkValidation(@Validated User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("user", user);
            return "index";
        }else {
            model.addAttribute("user", user);
            return "result";
        }
    }
}
