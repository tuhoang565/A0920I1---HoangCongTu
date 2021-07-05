package codegym.springcasestudy.service.impl;

import codegym.springcasestudy.model.Role;
import codegym.springcasestudy.repository.RoleRepository;
import codegym.springcasestudy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
