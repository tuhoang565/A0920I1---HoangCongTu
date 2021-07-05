package codegym.springcasestudy.service.impl;

import codegym.springcasestudy.model.EducationDegree;
import codegym.springcasestudy.repository.EducationDegreeRepository;
import codegym.springcasestudy.service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public Iterable<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(Long id) {
        return educationDegreeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }
}
