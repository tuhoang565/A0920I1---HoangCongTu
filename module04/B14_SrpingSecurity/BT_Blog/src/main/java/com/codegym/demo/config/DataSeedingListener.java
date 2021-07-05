package com.codegym.demo.config;

import com.codegym.demo.model.Role;
import com.codegym.demo.model.User;
import com.codegym.demo.repository.RoleRepository;
import com.codegym.demo.repository.UserRepository;
import com.codegym.demo.util.EncryptPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(roleRepository.findByRoleName("ROLE_ADMIN") ==  null){
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if(roleRepository.findByRoleName("ROLE_USER") == null){
            roleRepository.save(new Role("ROLE_USER"));
        }

//        them admin
        if(userRepository.findByUsername("admin") == null){
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(EncryptPasswordUtils.EncryptPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByRoleName("ROLE_USER"));
            roles.add(roleRepository.findByRoleName("ROLE_ADMIN"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }

//        them user
        if (userRepository.findByUsername("user") == null){
            User user = new User();
            user.setUsername("user");
            user.setPassword(EncryptPasswordUtils.EncryptPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByRoleName("ROLE_MEMBER"));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }
}
