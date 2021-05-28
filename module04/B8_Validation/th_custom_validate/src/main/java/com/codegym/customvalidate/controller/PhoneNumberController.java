package com.codegym.customvalidate.controller;

import com.codegym.customvalidate.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PhoneNumberController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "index";
    }

    @PostMapping("/")
    public String checkValidation(@Validated PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("phoneNumber", phoneNumber);
            return "index";
        }else {
            model.addAttribute("phoneNumber", phoneNumber);
            return "result";
        }
    }
}
