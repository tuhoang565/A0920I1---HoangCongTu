package dao;

import models.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CRUDDao {
    void insert(Customer customer) throws SQLException;
    List<Customer> getAll();
    Customer getById(int id);
    void delete(int id) throws SQLException;
    void update(Customer customer) throws SQLException;
    List<Customer> search(String string);
}
