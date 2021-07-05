package codegym.springcasestudy.service.impl;

import codegym.springcasestudy.model.Customer;
import codegym.springcasestudy.model.CustomerType;
import codegym.springcasestudy.repository.CustomerRepository;
import codegym.springcasestudy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByCustomerType(CustomerType customerType) {
        return customerRepository.findAllByCustomerType(customerType);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String customerName, Pageable pageable) {
        return customerRepository.findAllByCustomerNameContaining(customerName, pageable);
    }
}
