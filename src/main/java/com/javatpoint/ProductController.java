package com.javatpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepo;

    @GetMapping(value = "/products")
    public List<Product> getProduct() {

        List<Product> products = productRepo.findAll();
        return products;
    }
    @PostMapping(value = "/products")
    public Product saveOrUpdate(@RequestBody Product product) {
        return productRepo.save(product);

    }
    @DeleteMapping("/products/{product-id}")
    public String delete(@PathVariable("product-id") int productId) {
        productRepo.deleteById(productId);
        return"OK";
    }
}
