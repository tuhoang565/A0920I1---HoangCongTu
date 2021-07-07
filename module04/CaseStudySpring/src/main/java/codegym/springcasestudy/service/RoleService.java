package codegym.springcasestudy.service;

import codegym.springcasestudy.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(Long id);
    Role findByRoleName(String name);
}
