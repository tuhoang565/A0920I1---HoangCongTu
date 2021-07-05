package codegym.springcasestudy.service;

import codegym.springcasestudy.model.ServiceType;

public interface ServiceTypeService {
    Iterable<ServiceType> findAll();
    ServiceType findById(Long id);
    void save(ServiceType serviceType);
}
