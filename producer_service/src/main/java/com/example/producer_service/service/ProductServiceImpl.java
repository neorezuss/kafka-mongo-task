package com.example.producer_service.service;

import com.example.producer_service.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final KafkaTemplate<String, Product> kafkaTemplate;
    @Value("${spring.kafka.template.default-topic}")
    private String topic;

    @Override
    public Product sendProduct(Product product) {
        kafkaTemplate.send(topic, product);
        return product;
    }
}
