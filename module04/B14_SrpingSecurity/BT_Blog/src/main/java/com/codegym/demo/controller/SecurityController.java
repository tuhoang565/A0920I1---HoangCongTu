package com.codegym.demo.controller;

import com.codegym.demo.UserDto.UserDto;
import com.codegym.demo.model.Role;
import com.codegym.demo.model.User;
import com.codegym.demo.service.RoleService;
import com.codegym.demo.service.UserService;
import com.codegym.demo.util.EncryptPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
public class SecurityController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "authentication/login";
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage() {
        return new ModelAndView("authentication/register", "registerUser", new UserDto());
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("registerUser") UserDto registerUser) {
        User user = new User();
        user.setUsername(registerUser.getUsername());
        user.setPassword(EncryptPasswordUtils.EncryptPasswordUtils(registerUser.getPassword()));
        Role roleEntity = roleService.findByName("ROLE_MEMBER");
        Set<Role> listRoles = new HashSet<>();
        listRoles.add(roleEntity);
        user.setRoles(listRoles);
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/403")
    public String getPage403() {
        return "authentication/403";
    }

    @GetMapping("/home")
    public String homepage() {
        return "home";
    }
}
