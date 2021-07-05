package codegym.springcasestudy.repository;

import codegym.springcasestudy.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
