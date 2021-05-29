package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public boolean insertWithSp(Customer customer) {
        return customerRepo.insertWithSP(customer);
    }
}
