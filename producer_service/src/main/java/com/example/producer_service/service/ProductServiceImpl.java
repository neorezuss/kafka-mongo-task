package com.example.producer_service.service;

import com.example.producer_service.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final KafkaTemplate<String, Product> kafkaTemplate;

    @Override
    public Product sendProduct(Product product) {
        kafkaTemplate.send(
                kafkaTemplate.getDefaultTopic(),
                product
        );
        return product;
    }
}
