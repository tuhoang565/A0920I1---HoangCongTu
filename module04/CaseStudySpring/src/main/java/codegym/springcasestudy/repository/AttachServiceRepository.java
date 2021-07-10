package codegym.springcasestudy.repository;

import codegym.springcasestudy.model.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachServiceRepository extends JpaRepository<AttachService, Long> {
}
