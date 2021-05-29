package com.codegym.repository;

import com.codegym.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
public class CustomerRepoImpl implements CustomerRepo{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean insertWithSP(Customer customer) {
        String sqlString  = "CALL insert_customer(:firstName, :lastName, :address)";
        Query query = entityManager.createNativeQuery(sqlString);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        query.setParameter("address", customer.getAddress());
        return query.executeUpdate() == 0;
    }
}
