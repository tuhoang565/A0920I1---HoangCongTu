package codegym.springcasestudy.repository;

import codegym.springcasestudy.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division, Long> {
}
