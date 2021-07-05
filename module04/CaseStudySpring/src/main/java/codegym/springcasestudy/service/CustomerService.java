package codegym.springcasestudy.service;

import codegym.springcasestudy.model.Customer;
import codegym.springcasestudy.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Long id);
    void save(Customer customer);
    void remove(Long id);
    Iterable<Customer> findAllByCustomerType(CustomerType customerType);
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
