package com.Task.LowLevelTask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Task.LowLevelTask.model.Product;
import com.Task.LowLevelTask.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Implement methods for CRUD operations
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create a new product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Retrieve a product by its ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Retrieve a list of all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Update an existing product
    public Product updateProduct(Long id, Product updatedProduct) {
        // Check if the product with the given ID exists
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id);
            return productRepository.save(updatedProduct);
        } else {
            // Product with the given ID does not exist
            return null; // You can handle this case as needed
        }
    }

    // Delete a product by its ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}