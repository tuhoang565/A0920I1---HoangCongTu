package codegym.springcasestudy.service;

import codegym.springcasestudy.model.CustomerType;

public interface CustomerTypeService {
    Iterable<CustomerType> findAll();
    CustomerType findById(Long id);
    void save(CustomerType customerType);
    void remove(Long id);
}
