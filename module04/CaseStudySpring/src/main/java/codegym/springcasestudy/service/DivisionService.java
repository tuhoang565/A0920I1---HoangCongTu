package codegym.springcasestudy.service;

import codegym.springcasestudy.model.Division;

public interface DivisionService {
    Iterable<Division> findAll();
    Division findById(Long id);
    void save(Division division);
}
