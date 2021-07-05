package com.codegym.demo.service.impl;

import com.codegym.demo.model.Role;
import com.codegym.demo.repository.RoleRepository;
import com.codegym.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByRoleName(name);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Integer roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }
}
