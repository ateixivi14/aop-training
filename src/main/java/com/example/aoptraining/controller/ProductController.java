package com.example.aoptraining.controller;

import com.example.aoptraining.domain.Product;
import com.example.aoptraining.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    
    @GetMapping("/list")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/product")
    public Product getProductById(@RequestParam String productId) {
        return productService.getProductById(productId);
    }
    
    @PostMapping("/apply-discount")
    public ResponseEntity<String> updatePrice(@RequestBody ProductRequest productRequest) {
        Double price =  productService.applyDiscount(productRequest.getDiscountType(), productRequest.getProductId());
        return new ResponseEntity<>("Price updated: "+ price , HttpStatus.OK);
    }

    @PostMapping("/sell")
    public ResponseEntity<String> sellProduct(@RequestBody ProductRequest productRequest) {
        Product product = productService.sellProduct(productRequest.getProductId());
        return new ResponseEntity<>("Product " + product.getId() + " sold", HttpStatus.OK);
    }
    
}
