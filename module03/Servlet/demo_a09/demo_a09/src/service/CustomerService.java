package service;



import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    public List<Customer> getAll();

    public void addCus(Customer customer) throws SQLException;

    public void deleteCus(int id) throws SQLException;

    public Customer getCusById(int id);

    public List<Customer> getCusByName(String name);

}
