package com.example.demo.service;

import com.example.demo.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();
    Province findById(Long id);
    void save(Province province);
    void remove(Long id);
}
