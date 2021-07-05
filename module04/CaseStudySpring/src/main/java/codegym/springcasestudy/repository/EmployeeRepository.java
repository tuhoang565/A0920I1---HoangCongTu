package codegym.springcasestudy.repository;

import codegym.springcasestudy.model.Division;
import codegym.springcasestudy.model.EducationDegree;
import codegym.springcasestudy.model.Employee;
import codegym.springcasestudy.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    Iterable<Employee> findAllByDivision(Division division);
    Iterable<Employee> findAllByPosition(Position position);
    Iterable<Employee> findAllByEducationDegree(EducationDegree educationDegree);

    @Query("select e from Employee e where e.employeeName like %?1%" +
            " or e.employeeIdCard like %?1%" +
            " or e.position.positionName like %?1%" +
            " or e.division.divisionName like %?1%" +
            " or e.educationDegree.educationDegreeName like %?1%")
    Page<Employee> search(String keyword, Pageable pageable);
}
