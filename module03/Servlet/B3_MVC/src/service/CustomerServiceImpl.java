package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {
    private static Map<Integer, Customer> customerMap;
    static {
        customerMap = new HashMap<>();
        customerMap.put(1, new Customer(1, "Tu", "tu@gmail.com", "Hue"));
        customerMap.put(2, new Customer(2, "Tung", "tung@gmail.com", "Hue"));
        customerMap.put(3, new Customer(3, "Van", "van@gmail.com", "Da Nang"));
        customerMap.put(4, new Customer(4, "My", "my@gmail.com", "Quang Nam"));
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerMap.get(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        customerMap.put(id, customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerMap.remove(id);
    }
}
