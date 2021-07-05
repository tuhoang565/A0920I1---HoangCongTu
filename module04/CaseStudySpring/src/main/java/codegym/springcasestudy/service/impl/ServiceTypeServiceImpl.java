package codegym.springcasestudy.service.impl;

import codegym.springcasestudy.model.ServiceType;
import codegym.springcasestudy.repository.ServiceTypeRepository;
import codegym.springcasestudy.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public Iterable<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public ServiceType findById(Long id) {
        return serviceTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }
}
