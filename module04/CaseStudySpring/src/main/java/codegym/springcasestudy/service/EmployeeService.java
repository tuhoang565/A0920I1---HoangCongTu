package codegym.springcasestudy.service;

import codegym.springcasestudy.model.Division;
import codegym.springcasestudy.model.EducationDegree;
import codegym.springcasestudy.model.Employee;
import codegym.springcasestudy.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    Employee findById(Long id);
    void save(Employee employee);
    void remove(Long id);
    Page<Employee> search(String keyword, Pageable pageable);
    Iterable<Employee> findAllByDivision(Division division);
    Iterable<Employee> findAllByPosition(Position position);
    Iterable<Employee> findAllByEducationDegree(EducationDegree educationDegree);
}
