package com.example.aoptraining.controller;

import com.example.aoptraining.service.DiscountType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequest {
    private String productId;
    private DiscountType discountType;
}
