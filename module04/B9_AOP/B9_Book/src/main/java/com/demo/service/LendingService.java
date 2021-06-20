package com.demo.service;

import com.demo.model.Lending;

import java.util.List;


public interface LendingService {
    Lending findById(Long id);
    void save(Lending lending);
    Iterable<Lending> findAll();
}
