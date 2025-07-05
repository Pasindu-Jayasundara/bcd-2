package org.example.ee.core.service;

import jakarta.ejb.Remote;
import org.example.ee.core.model.Product;

import java.util.List;

@Remote
public interface ProductService {

    Product getProductById(Long id);
    Product getProductByName(String name);
    List<Product> getProductsByCategory(String category);
    List<Product> getAllProducts();
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long id);
}
