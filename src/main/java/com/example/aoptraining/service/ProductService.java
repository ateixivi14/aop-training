package com.example.aoptraining.service;

import com.example.aoptraining.aop.Logging;
import com.example.aoptraining.aop.TrackTime;
import com.example.aoptraining.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService implements CommandLineRunner {
    
    private final DiscountService discountService;
    
    private ArrayList<Product> products = new ArrayList<>();
    
    
    public List<Product> findAll() {
        return products;
    }
    
    public Product sellProduct(String productId) {
       Product product = products.stream().filter(p -> p.getId().equals(productId)).findFirst().orElseThrow();
       products.remove(product);
       return product;
    }
    
    public Product getProductById(String productId) {
        Product product = products.stream().filter(p -> p.getId().equals(productId)).findFirst().orElseThrow();
        return product;
    }
    
    @TrackTime
    public Double applyDiscount(DiscountType discountType, String productId) {
        Product product = products.stream().filter(p -> p.getId().equals(productId)).findFirst().orElseThrow();
        product.setPrice(discountService.applyDiscount(discountType, product.getPrice()));
        return product.getPrice();
    }

    @Override
    public void run(String... args) throws Exception {
        products.add(new Product(String.valueOf(UUID.randomUUID()), "Mobile", "CLK98123", 9000.00));
        products.add(new Product(String.valueOf(UUID.randomUUID()), "Smart TV", "LGST09167", 60000.00));
        products.add(new Product(String.valueOf(UUID.randomUUID()), "Washing Machine", "38753BK9", 9000.00));
        products.add(new Product(String.valueOf(UUID.randomUUID()), "Laptop", "LHP29OCP", 24000.00));
        products.add(new Product(String.valueOf(UUID.randomUUID()), "Air Conditioner", "ACLG66721", 30000.00));
        products.add(new Product(String.valueOf(UUID.randomUUID()), "Refrigerator ", "12WP9087", 10000.00));
    }
}
