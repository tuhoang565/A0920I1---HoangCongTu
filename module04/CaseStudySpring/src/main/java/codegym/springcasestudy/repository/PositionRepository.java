package codegym.springcasestudy.repository;

import codegym.springcasestudy.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
