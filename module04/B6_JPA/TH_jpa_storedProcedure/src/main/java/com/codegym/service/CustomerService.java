package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.context.annotation.Bean;


public interface CustomerService {
    boolean insertWithSp(Customer customer);
}
