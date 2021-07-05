package codegym.springcasestudy.repository;

import codegym.springcasestudy.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentTypeRepository extends JpaRepository<RentType, Long> {
}
