package com.demo.service.impl;

import com.demo.model.Lending;
import com.demo.repository.LendingRepository;
import com.demo.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendingServiceImpl implements LendingService {
    @Autowired
    private LendingRepository lendingRepository;
    @Override
    public Lending findById(Long id) {
        return lendingRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Lending lending) {
        lendingRepository.save(lending);
    }

    @Override
    public Iterable<Lending> findAll() {
        return lendingRepository.findAll();
    }
}
