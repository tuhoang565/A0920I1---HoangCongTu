package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static Map<String, Customer> customerMap;

    public CustomerServiceImpl(){
        if(customerMap != null){
            return;
        }
        customerMap = new HashMap<>();
        customerMap.put("1", new Customer("1", "Tu", "20/2/2000", "Hue"));
        customerMap.put("2", new Customer("2", "Tung", "20/2/2000", "Da Nang"));
        customerMap.put("3", new Customer("3", "Anh", "20/2/2000", "Hue"));
        customerMap.put("4", new Customer("4", "Viet", "20/2/2000", "Quang Nam"));
        customerMap.put("5", new Customer("5", "Quoc", "20/2/2000", "Hue"));
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerMap.get(id);
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        if(customerMap.get(customer.getId()) != null){
            customerMap.put(customer.getId(), customer);
        }
    }

    @Override
    public void deleteCustomerById(String id) {
        if(customerMap.get(id) != null){
            customerMap.remove(id);
        }
    }
}
