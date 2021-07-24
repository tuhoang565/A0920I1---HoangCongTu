package com.springexam.service;

import com.springexam.model.Product;
import com.springexam.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    Product findById(Long id);
    void save(Product product);
    void remove(Long id);
    Iterable<Product> findAllByProductType(ProductType productType);
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
