package codegym.springcasestudy.service.impl;

import codegym.springcasestudy.model.RentType;
import codegym.springcasestudy.repository.RentTypeRepository;
import codegym.springcasestudy.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public Iterable<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(Long id) {
        return rentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }
}
