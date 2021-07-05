package codegym.springcasestudy.repository;

import codegym.springcasestudy.model.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDegreeRepository extends JpaRepository<EducationDegree, Long> {
}
