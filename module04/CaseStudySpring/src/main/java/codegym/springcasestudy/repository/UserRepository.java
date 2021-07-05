package codegym.springcasestudy.repository;

import codegym.springcasestudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
