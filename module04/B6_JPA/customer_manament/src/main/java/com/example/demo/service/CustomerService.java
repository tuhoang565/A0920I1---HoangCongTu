package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.exception.DuplicateEmailException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Long id) throws Exception;
    void save(Customer customer) throws DuplicateEmailException;
    void remove(Long id);
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
