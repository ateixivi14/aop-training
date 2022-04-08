package com.example.aoptraining.service;


public enum DiscountType {
    FIFTY_PER_CENT (0.50),
    TWENTY_PER_CENT (0.20),
    TEN_PER_CENT (0.10), 
    THIRTY_PER_CENT (0.30);
    
    private final double percent;

    DiscountType(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }
}
