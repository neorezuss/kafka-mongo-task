package com.example.producer_service.service;

import com.example.producer_service.entity.Product;

public interface ProductService {
    public Product sendProduct(Product product);
}
