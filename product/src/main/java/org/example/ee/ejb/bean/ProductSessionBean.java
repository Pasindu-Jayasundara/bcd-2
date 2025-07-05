package org.example.ee.ejb.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.ee.core.model.Product;
import org.example.ee.core.service.ProductService;

import java.util.List;

@Stateless
public class ProductSessionBean implements ProductService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Product getProductById(Long id) {
        return em.find(Product.class,id);
    }

    @Override
    public Product getProductByName(String name) {

        return em.createNamedQuery("Product.findByName",Product.class)
                .setParameter("name",name)
                .getSingleResult();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {

        return em.createNamedQuery("Product.findByCategory",Product.class)
                .setParameter("category",category)
                .getResultList();
    }

    @Override
    public List<Product> getAllProducts() {
        return em.createNamedQuery("Product.getAll",Product.class)
                .getResultList();
    }

    @Override
    public void addProduct(Product product) {
        em.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        em.merge(product);
    }

    @Override
    public void deleteProduct(Long id) {
        em.remove(getProductById(id));
    }
}
