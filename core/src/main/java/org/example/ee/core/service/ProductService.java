package org.example.ee.core.service;

import jakarta.ejb.Remote;
import org.example.ee.core.model.Product;

import java.util.List;
import java.util.Optional;

@Remote
public interface ProductService {

    Optional<Product> getProductById(Long id);
    Optional<Product> getProductByName(String name);
    List<Product> getProductsByCategory(String category);
    List<Product> getAllProducts();
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long id);
}
