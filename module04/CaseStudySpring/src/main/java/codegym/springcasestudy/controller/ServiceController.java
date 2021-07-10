package codegym.springcasestudy.controller;

import codegym.springcasestudy.model.Customer;
import codegym.springcasestudy.model.RentType;
import codegym.springcasestudy.model.Service;
import codegym.springcasestudy.model.ServiceType;
import codegym.springcasestudy.service.RentTypeService;
import codegym.springcasestudy.service.ServiceService;
import codegym.springcasestudy.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
    public Iterable<RentType> rentTypes() {
        return rentTypeService.findAll();
    }

    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> serviceTypes() {
        return serviceTypeService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView listService() {
        Iterable<Service> services = serviceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/service/list");
        modelAndView.addObject("services", services);
        return modelAndView;
    }

    @GetMapping("/create-service")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/service/create");
        modelAndView.addObject("service", new Service());
        return modelAndView;
    }

    @PostMapping("/create-service")
    public ModelAndView saveService(@Validated @ModelAttribute("service") Service service, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/service/create");
            modelAndView.addObject("service", service);
            return modelAndView;
        }
        serviceService.save(service);
        ModelAndView modelAndView = new ModelAndView("/service/create");
        modelAndView.addObject("service", new Service());
        modelAndView.addObject("message", "New service was added");
        return modelAndView;
    }

    @GetMapping("/edit-service/{serviceId}")
    public ModelAndView showEditForm(@PathVariable Long serviceId) {
        Service service = serviceService.findById(serviceId);
        ModelAndView modelAndView = new ModelAndView("/service/edit");
        modelAndView.addObject("service", service);
        return modelAndView;
    }

    @PostMapping("/edit-service")
    public ModelAndView updateService(@Validated @ModelAttribute("service") Service service, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/service/edit");
            modelAndView.addObject("service", service);
            return modelAndView;
        }
        serviceService.save(service);
        ModelAndView modelAndView = new ModelAndView("/service/edit");
        modelAndView.addObject("service", service);
        modelAndView.addObject("message", "Service updated successful");
        return modelAndView;
    }

    @GetMapping("/delete-service/{serviceId}")
    public String deleteService(@PathVariable Long serviceId) {
        serviceService.remove(serviceId);
        return "redirect:/service/list";
    }
}
