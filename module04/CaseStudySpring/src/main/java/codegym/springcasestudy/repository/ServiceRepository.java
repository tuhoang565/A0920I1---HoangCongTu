package codegym.springcasestudy.repository;

import codegym.springcasestudy.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
