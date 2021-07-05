package codegym.springcasestudy.controller;

import codegym.springcasestudy.model.*;
import codegym.springcasestudy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private EducationDegreeService educationDegreeService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @ModelAttribute("divisions")
    public Iterable<Division> getDivision(){
        return divisionService.findAll();
    }
    @ModelAttribute("positions")
    public Iterable<Position> getPosition(){
        return positionService.findAll();
    }
    @ModelAttribute("educationDegrees")
    public Iterable<EducationDegree> getEducationDegree(){
        return educationDegreeService.findAll();
    }
    @ModelAttribute("roles")
    public List<Role> getRole(){
        return roleService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView getAllEmployee(@RequestParam("searchKey")Optional<String> searchKey, Pageable pageable){
        Page<Employee> employees;
        if(searchKey.isPresent()){
            employees = employeeService.search(searchKey.get(), pageable);
        }else {
            employees = employeeService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createEmployee(@ModelAttribute("employee") Employee employee, @ModelAttribute("user") User user){
        employeeService.save(employee);

        Role role = roleService.
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("message", "New employee was created");
        return modelAndView;
    }
}
