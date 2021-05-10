package repository;



import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    void save(Customer student) throws SQLException;

    Customer findById(int id);

    void remove(int id) throws SQLException;

    List<Customer> searchCustomer(String name);
}
