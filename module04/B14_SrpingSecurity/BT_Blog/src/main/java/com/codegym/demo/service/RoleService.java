package com.codegym.demo.service;

import com.codegym.demo.model.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String name);
    List<Role> findAll();
    Role findById(Integer roleId);
}
