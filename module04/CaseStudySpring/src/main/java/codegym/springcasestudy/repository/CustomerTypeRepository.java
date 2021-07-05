package codegym.springcasestudy.repository;

import codegym.springcasestudy.model.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerTypeRepository extends PagingAndSortingRepository<CustomerType, Long> {
}
