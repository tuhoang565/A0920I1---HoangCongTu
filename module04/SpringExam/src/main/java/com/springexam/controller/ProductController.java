package com.springexam.controller;

import com.springexam.model.Product;
import com.springexam.model.ProductType;
import com.springexam.repository.ProductRepository;
import com.springexam.service.ProductService;
import com.springexam.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;

    @ModelAttribute("productTypes")
    public Iterable<ProductType> productTypes(){
        return productTypeService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/product/create");
            modelAndView.addObject("product", product);
            return modelAndView;
        }
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New product was created successful");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listCustomers(@RequestParam("searchKey") Optional<String> searchKey, @PageableDefault(size = 5) Pageable pageable){
        Page<Product> products;
        if(searchKey.isPresent()){
            products = productService.findAllByNameContaining(searchKey.get(), pageable);
        }else {
            products = productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }


//    @GetMapping("/edit-customer/{customerId}")
//    public ModelAndView showEditForm(@PathVariable Long customerId){
//        Customer customer = customerService.findById(customerId);
//        ModelAndView modelAndView = new ModelAndView("/customer/edit");
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }
//
//    @PostMapping("/edit-customer")
//    public ModelAndView updateCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            ModelAndView modelAndView = new ModelAndView("/customer/edit");
//            modelAndView.addObject("customer", customer);
//            return modelAndView;
//        }
//        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("/customer/edit");
//        modelAndView.addObject("customer", customer);
//        modelAndView.addObject("message", "Customer updated successful");
//        return modelAndView;
//    }
//
    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable("id") Long id){
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/product/delete");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/product/list");
        productService.remove(id);
        Page<Product> products = productService.findAll(pageable);
        modelAndView.addObject("products", products);
        return modelAndView;
    }

}
