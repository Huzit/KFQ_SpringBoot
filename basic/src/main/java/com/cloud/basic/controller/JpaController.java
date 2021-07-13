package com.cloud.basic.controller;

import java.util.List;

import com.cloud.basic.repository.ProductRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cloud.basic.model.Product;
import com.cloud.basic.repository.ProductRepository;

@RestController
public class JpaController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductRepository2 productRepository2;

    @GetMapping("/jpa/product")
    public List<Product> product() {
        List<Product> list = productRepository.findAll();
        productRepository2.findAll();
        return list;
    }

    @PostMapping("/jpa/product")
    public String productPost(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/jpa/product";
    }
}