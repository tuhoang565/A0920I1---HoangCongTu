package com.springexam.service.impl;

import com.springexam.model.ProductType;
import com.springexam.repository.ProductTypeRepository;
import com.springexam.service.ProductService;
import com.springexam.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl implements ProductTypeService{
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public Iterable<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType findById(Long id) {
        return productTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ProductType productType) {
        productTypeRepository.save(productType);
    }

    @Override
    public void remove(Long id) {
        productTypeRepository.deleteById(id);
    }
}
