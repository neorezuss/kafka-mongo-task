package com.example.producer_service.controller;

import com.example.producer_service.entity.Product;
import com.example.producer_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    private Product saveProduct(@RequestBody Product product) {
        return productService.sendProduct(product);
    }
}
