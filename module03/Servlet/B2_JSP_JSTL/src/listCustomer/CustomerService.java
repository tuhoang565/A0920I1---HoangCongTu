package listCustomer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(String id);
    List<Customer> getAll();
}
