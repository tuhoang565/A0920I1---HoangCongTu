package codegym.springcasestudy.service;

import codegym.springcasestudy.model.EducationDegree;

public interface EducationDegreeService {
    Iterable<EducationDegree> findAll();
    EducationDegree findById(Long id);
    void save(EducationDegree educationDegree);
}
