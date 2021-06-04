package com.demo.service;

import com.demo.model.Lending;


public interface LendingService {
    Lending findById(Long id);
    void save(Lending lending);
}
