package codegym.springcasestudy.service;

import codegym.springcasestudy.model.Customer;
import codegym.springcasestudy.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
    Iterable<Service> findAll();
    Service findById(Long serviceId);
    void save(Service service);
    void remove(Long serviceId);
    Page<Service> findAllByServiceNameContaining(String serviceName, Pageable pageable);
}
