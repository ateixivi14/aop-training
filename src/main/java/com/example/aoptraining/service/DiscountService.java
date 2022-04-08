package com.example.aoptraining.service;

import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    public Double applyDiscount(DiscountType discountType, double price) {
        return price - discountType.getPercent()*price;
    }
}
