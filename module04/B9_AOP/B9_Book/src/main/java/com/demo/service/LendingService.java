package com.demo.service;

import com.demo.model.Lending;
import org.springframework.stereotype.Service;


public interface LendingService {
    Lending findById(Long id);

}
