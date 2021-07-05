package codegym.springcasestudy.service;

import codegym.springcasestudy.model.Service;

public interface ServiceService {
    Iterable<Service> findAll();
    Service findById(Long id);
    void save(Service service);
}
