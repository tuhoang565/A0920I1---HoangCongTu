package service.impl;




import model.Customer;
import repository.CustomerRepositoryImpl;
import service.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void addCus(Customer customer) {
        try {
            customerRepository.save(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCus(int id) {
        try {
            customerRepository.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCusById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getCusByName(String name) {
        return customerRepository.searchCustomer(name);
    }
}
