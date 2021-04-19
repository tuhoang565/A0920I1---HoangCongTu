package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements ProductServiceImpl {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "iPhone 6", "Silver", "Apple", 1500));
        productMap.put(2, new Product(2, "iPhone 7", "Black", "Apple", 2000));
        productMap.put(3, new Product(3, "Samsung A7", "Gold", "Samsung", 1300));
        productMap.put(4, new Product(4, "Samsung S21", "White", "Samsung", 2000));
    }

    @Override
    public void insertProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public List<Product> getAllProduct() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void updateProduct(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        productMap.remove(id);
    }

    @Override
    public Product getProductById(int id) {
        return productMap.get(id);
    }

    @Override
    public Product searchProduct(String name) {
        Product product = null;
        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            product = entry.getValue();
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}

