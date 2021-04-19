package service;

import model.Customer;


import java.util.List;

public interface ICustomerService {
    void insertCustomer(Customer customer);
    Customer getCustomerById(int id);
    List<Customer> getAllCustomer();
    void updateCustomer(int id, Customer customer);
    void deleteCustomer(int id);
}
