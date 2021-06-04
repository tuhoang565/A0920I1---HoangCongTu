package com.demo.repository;

import com.demo.model.Lending;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendingRepository extends PagingAndSortingRepository<Lending, Long> {

}
