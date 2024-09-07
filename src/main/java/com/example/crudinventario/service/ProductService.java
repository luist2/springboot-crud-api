package com.example.crudinventario.service;

import com.example.crudinventario.entity.Product;
import com.example.crudinventario.repositorio.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public void updateProduct(Long productId, Product product) {
        if (productRepository.existsById(productId)) {
            product.setId(productId);
            productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with id " + productId);
        }
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
