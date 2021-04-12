package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(String id);
    List<Customer> getAll();
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(String id);
}
