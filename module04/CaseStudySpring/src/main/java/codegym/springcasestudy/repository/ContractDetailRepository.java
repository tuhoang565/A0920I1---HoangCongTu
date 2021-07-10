package codegym.springcasestudy.repository;

import codegym.springcasestudy.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, Long> {
}
