package com.springexam.repository;

import com.springexam.model.ProductType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends PagingAndSortingRepository<ProductType, Long> {
}
