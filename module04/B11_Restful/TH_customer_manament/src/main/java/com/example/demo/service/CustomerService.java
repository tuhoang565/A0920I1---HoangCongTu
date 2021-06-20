package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.exception.DuplicateEmailException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CustomerService {
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Long id) throws Exception;
    void save(Customer customer) throws DuplicateEmailException;
    void remove(Long id);

}
