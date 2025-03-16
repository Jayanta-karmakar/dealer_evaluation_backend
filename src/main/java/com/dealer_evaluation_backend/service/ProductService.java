package com.dealer_evaluation_backend.service;

import com.dealer_evaluation_backend.model.Product;
import com.dealer_evaluation_backend.model.ProductWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 16/03/25, Sunday
 **/

@Slf4j
@Service
public class ProductService {

    private final ObjectMapper objectMapper;
    private List<Product> products;

    public ProductService() {
        this.objectMapper = new ObjectMapper();
        this.readJson();
    }

    public void readJson() {
        try {
            File file = new File("src/main/resources/products.json");
            ProductWrapper wrapper = objectMapper
                    .readValue(file, new TypeReference<ProductWrapper>() {
                    });
            this.products = wrapper.getProducts();
        } catch (IOException e) {
            log.error("Error while reading products.json file : {}", e.getMessage());
        }
    }

    public List<String> getAllProducts() {
        return products.stream()
                .map(Product::getProduct)
                .toList();
    }

    public List<String> getDealersForProduct(String productName) {
        return products.stream()
                .filter(p -> p.getProduct().equalsIgnoreCase(productName))
                .findFirst()
                .map(Product::getDealers)
                .orElseThrow(() -> new RuntimeException("Could not find dealers for this product"));
    }
}
