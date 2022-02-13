package com.example.consumer_service.service;

import com.example.consumer_service.entity.Product;
import com.example.consumer_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void consumeProduct(Product product) {
        System.out.println(product);
        productRepository.save(product);
    }
}
