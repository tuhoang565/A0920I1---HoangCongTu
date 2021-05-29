package com.codegym.repository;

import com.codegym.model.Customer;

public interface CustomerRepo {
    boolean insertWithSP(Customer customer);
}
