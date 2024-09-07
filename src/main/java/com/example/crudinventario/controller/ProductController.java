package com.example.crudinventario.controller;

import com.example.crudinventario.entity.Product;
import com.example.crudinventario.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Optional<Product> get(@PathVariable("productId") Long productId){
        return productService.getProduct(productId);
    }

    @PostMapping
    public void save(@RequestBody Product product){
        productService.saveProduct(product);
    }

    @PutMapping("/{productId}")
    public void update(@PathVariable("productId") Long productId, @RequestBody Product product){
        productService.updateProduct(productId, product);
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
    }
}
