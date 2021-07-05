package codegym.springcasestudy.service;

import codegym.springcasestudy.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
}
