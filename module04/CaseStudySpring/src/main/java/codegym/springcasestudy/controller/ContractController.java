package codegym.springcasestudy.controller;

import codegym.springcasestudy.model.Contract;
import codegym.springcasestudy.model.Customer;
import codegym.springcasestudy.model.Employee;
import codegym.springcasestudy.model.Service;
import codegym.springcasestudy.service.ContractService;
import codegym.springcasestudy.service.CustomerService;
import codegym.springcasestudy.service.EmployeeService;
import codegym.springcasestudy.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ContractService contractService;

    @ModelAttribute("employees")
    public Iterable<Employee> getAllEmployee(Pageable pageable){
        return employeeService.findAll(pageable);
    }
    @ModelAttribute("customers")
    public Iterable<Customer> getAllCustomer(Pageable pageable){
        return customerService.findAll(pageable);
    }
    @ModelAttribute("services")
    public Iterable<Service> getAllService(){
        return serviceService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        modelAndView.addObject("contract", new Contract());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveContract(@ModelAttribute("contract") Contract contract){
        contractService.save(contract);
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("message", "New contract was created successful");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listContract(){
        List<Contract> contracts = contractService.findAll();
        ModelAndView modelAndView = new ModelAndView("/contract/list");
        modelAndView.addObject("contracts", contracts);
        return modelAndView;
    }

    @GetMapping("/delete/{contractId}")
    public String deleteContract(@PathVariable Long contractId){
        contractService.delete(contractId);
        return "redirect:/contract/list";
    }
}
