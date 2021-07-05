package codegym.springcasestudy.service.impl;

import codegym.springcasestudy.model.Division;
import codegym.springcasestudy.repository.DivisionRepository;
import codegym.springcasestudy.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionServiceImpl implements DivisionService{
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Division findById(Long id) {
        return divisionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }
}
