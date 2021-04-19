package service;

import model.Product;

import java.util.List;

public interface ProductServiceImpl {
    void insertProduct(Product product);
    List<Product> getAllProduct();
    void updateProduct(int id, Product product);
    void deleteProduct(int id);
    Product getProductById(int id);
    Product searchProduct(String name);
}
