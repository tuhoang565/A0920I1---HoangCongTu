package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.CustomerService;
import com.example.demo.service.exception.DuplicateEmailException;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;

    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable(){
        return new ModelAndView("customer/inputs-not-acceptable");
    }

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) throws DuplicateEmailException {

           customerService.save(customer);
           ModelAndView modelAndView = new ModelAndView("/customer/create");
           modelAndView.addObject("customer", new Customer());
           modelAndView.addObject("message", "New customer created successfully");
           return modelAndView;
    }

    @GetMapping("/customers")
    public ModelAndView listCustomers(@RequestParam("s") Optional<String> s, Pageable pageable) throws Exception {
        Page<Customer> customers;
        if(s.isPresent()){
            customers = customerService.findAllByFirstNameContaining(s.get(), pageable);
        }else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) throws DuplicateEmailException, Exception {
            Customer customer = customerService.findById(id);
            if (customer != null) {
                ModelAndView modelAndView = new ModelAndView("/customer/edit");
                modelAndView.addObject("customer", customer);
                return modelAndView;
            } else {
                ModelAndView modelAndView = new ModelAndView("/error.404");
                return modelAndView;
            }
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        try {
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("message", "Customer updated successfully");
            return modelAndView;
        }catch (DuplicateEmailException e){
            return new ModelAndView("customer/inputs-not-acceptable");
        } catch (Exception e) {
            return new ModelAndView("customer/inputs-not-acceptable");
        }
    }

//    @GetMapping("/delete-customer/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id){
//        try {
//            Customer customer = customerService.findById(id);
//            if (customer != null) {
//                ModelAndView modelAndView = new ModelAndView("/customer/delete");
//                modelAndView.addObject("customer", customer);
//                return modelAndView;
//            } else {
//                ModelAndView modelAndView = new ModelAndView("/error.404");
//                return modelAndView;
//            }
//        }catch (Exception e){
//            return new ModelAndView("redirect:/customers");
//        }
//    }
//
//    @PostMapping("/delete-customer")
//    public String deleteCustomer(@ModelAttribute("customer") Customer customer){
//        customerService.remove(customer.getId());
//        return "redirect:customers";
//    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        try {
            Customer customer = customerService.findById(id);
            if (customer != null) {
                ModelAndView modelAndView = new ModelAndView("/customer/delete");
                modelAndView.addObject("customer", customer);
                return modelAndView;
            } else {
                ModelAndView modelAndView = new ModelAndView("/error.404");
                return modelAndView;
            }
        }catch (Exception e){
            return new ModelAndView("redirect:/customers");
        }
    }

    @PostMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable Long id, Pageable pageable, Model model){
        customerService.remove(id);
        Page<Customer> customers = customerService.findAll(pageable);
        model.addAttribute("customers", customers);
        return "redirect:/customers";
    }
}
