package codegym.springcasestudy.controller;

import codegym.springcasestudy.model.Customer;
import codegym.springcasestudy.model.CustomerType;
import codegym.springcasestudy.service.CustomerService;
import codegym.springcasestudy.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> customerTypes(){
        return customerTypeService.findAll();
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){

        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer was created successful");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listCustomers(@RequestParam("searchKey") Optional<String> searchKey, Pageable pageable){
        Page<Customer> customers;
        if(searchKey.isPresent()){
            customers = customerService.findAllByFirstNameContaining(searchKey.get(), pageable);
        }else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/edit-customer/{customerId}")
    public ModelAndView showEditForm(@PathVariable Long customerId){
        Customer customer = customerService.findById(customerId);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfull");
        return modelAndView;
    }

    @GetMapping("/delete-customer/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId){
        customerService.remove(customerId);
        return "redirect:/customer/list";
    }
}
