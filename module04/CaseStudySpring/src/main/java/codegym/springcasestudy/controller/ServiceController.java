package codegym.springcasestudy.controller;

import codegym.springcasestudy.model.RentType;
import codegym.springcasestudy.model.Service;
import codegym.springcasestudy.model.ServiceType;
import codegym.springcasestudy.service.RentTypeService;
import codegym.springcasestudy.service.ServiceService;
import codegym.springcasestudy.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private RentTypeService rentTypeService;

    @ModelAttribute("rentTypes")
    public Iterable<RentType> rentTypes(){return rentTypeService.findAll();}
    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> serviceTypes(){
        return serviceTypeService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView listService(){
        Iterable<Service> services = serviceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/service/list");
        modelAndView.addObject("services", services);
        return modelAndView;
    }

    @GetMapping("/create-service")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/service/create");
        modelAndView.addObject("service", new Service());
        return modelAndView;
    }

    @PostMapping("/create-service")
    public ModelAndView saveService(@ModelAttribute("service") Service service){
        serviceService.save(service);
        ModelAndView modelAndView = new ModelAndView("/service/create");
        modelAndView.addObject("service", new Service());
        modelAndView.addObject("message", "New service was added");
        return modelAndView;
    }
}
