package com.phonemanament.service;


import com.phonemanament.model.Smartphone;

import javax.persistence.criteria.CriteriaBuilder;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();
    Smartphone findById(Integer id);
    Smartphone save(Smartphone phone);
    Smartphone remove(Integer id);
}
