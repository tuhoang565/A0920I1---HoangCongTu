package codegym.springcasestudy.config;

import codegym.springcasestudy.model.Role;
import codegym.springcasestudy.model.User;
import codegym.springcasestudy.repository.RoleRepository;
import codegym.springcasestudy.repository.UserRepository;
import codegym.springcasestudy.util.EncryptPasswordUtils;
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
        if(roleRepository.findByRoleName("ROLE_ADMIN")== null){
            roleRepository.save(new Role("ROLE_ADMIN"));
        }
        if(roleRepository.findByRoleName("ROLE_USER")== null){
            roleRepository.save(new Role("ROLE_USER"));
        }

//        them admin
        if(userRepository.findByUsername("admin") == null){
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(EncryptPasswordUtils.EncryptPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByRoleName("ROLE_ADMIN"));
            roles.add((roleRepository.findByRoleName("ROLE_USER")));
            admin.setRoles(roles);
            userRepository.save(admin);
        }
    }
}
