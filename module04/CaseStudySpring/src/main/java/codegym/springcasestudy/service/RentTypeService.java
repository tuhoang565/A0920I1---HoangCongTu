package codegym.springcasestudy.service;

import codegym.springcasestudy.model.RentType;

public interface RentTypeService {
    Iterable<RentType> findAll();
    RentType findById(Long id);
    void save(RentType rentType);
}
