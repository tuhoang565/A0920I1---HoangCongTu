package com.codegym.cms.controller;

import com.codegym.cms.service.CustomerService;
import com.codegym.cms.service.impl.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    @GetMapping("/")
    public String index(Model model){
        List customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "index";
    }
}