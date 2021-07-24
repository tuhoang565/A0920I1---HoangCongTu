package com.springexam.repository;

import com.springexam.model.Product;
import com.springexam.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Iterable<Product> findAllByProductType(ProductType productType);
    @Query("select e from Product e where e.name like %?1%")
    Page<Product> findAllByNameContaining(String name, Pageable pageable);

}
