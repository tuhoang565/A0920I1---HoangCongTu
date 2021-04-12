package listCustomer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> customerMap;

    static {
        customerMap = new HashMap<>();
        customerMap.put(1, new Customer("1", "Tu", "20/2/2000", "Da Nang", "https://www.w3schools.com/w3css/img_lights.jpg"));
        customerMap.put(2, new Customer("2", "Anh", "20/2/2000", "Quang Nam", "https://www.w3schools.com/w3css/img_lights.jpg"));
        customerMap.put(3, new Customer("3", "Tien", "20/2/2000", "Hue", "https://www.w3schools.com/w3css/img_lights.jpg"));
        customerMap.put(4, new Customer("4", "Viet", "20/2/2000", "Da Nang", "https://www.w3schools.com/w3css/img_lights.jpg"));
        customerMap.put(5, new Customer("5", "Phap", "20/2/2000", "Da Nang", "https://www.w3schools.com/w3css/img_lights.jpg"));
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerMap.get(id);
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customerMap.values());
    }
}
