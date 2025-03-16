package com.dealer_evaluation_backend.controller;

import com.dealer_evaluation_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 16/03/25, Sunday
 **/

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<String> getProductsList() {
        return productService.getAllProducts();
    }

    @GetMapping("/getdealers/{product}")
    public List<String> getDealers(@PathVariable String product) {
        return productService.getDealersForProduct(product);
    }
}
