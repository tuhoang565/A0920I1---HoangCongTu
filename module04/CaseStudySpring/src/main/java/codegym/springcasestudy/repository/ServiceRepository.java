package codegym.springcasestudy.repository;

import codegym.springcasestudy.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends PagingAndSortingRepository<Service, Long> {
    Iterable<ServiceType> findAllByServiceType(ServiceType serviceType);
    Iterable<RentType> findAllByRentType(RentType rentType);
    Page<Service> findAllByServiceNameContaining(String serviceName, Pageable pageable);
}
