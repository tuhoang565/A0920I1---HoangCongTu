package codegym.springcasestudy.service.impl;

import codegym.springcasestudy.repository.ServiceRepository;
import codegym.springcasestudy.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public Iterable<codegym.springcasestudy.model.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public codegym.springcasestudy.model.Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(codegym.springcasestudy.model.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Long serviceId) {
        serviceRepository.deleteById(serviceId);
    }

    @Override
    public Page<codegym.springcasestudy.model.Service> findAllByServiceNameContaining(String serviceName, Pageable pageable) {
        return serviceRepository.findAllByServiceNameContaining(serviceName, pageable);
    }
}
