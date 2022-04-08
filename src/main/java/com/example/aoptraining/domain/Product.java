package com.example.aoptraining.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {
    private final String id;
    private final String name;
    private final String storeId;
    private Double price;
}
