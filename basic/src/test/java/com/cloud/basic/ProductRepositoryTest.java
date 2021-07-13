package com.cloud.basic;

import static org.junit.jupiter.api.Assertions.*;

import com.cloud.basic.model.Product;
import com.cloud.basic.repository.ProductRepository;
import org.junit.jupiter.api.Test;	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductRepositoryTest {

	@Autowired
	ProductRepository productRepository;

	@Test
	void getTest(){
		System.out.println("testsetsetsetset");
	}

	@Test
	void addProduct() {
		Product product = new Product();
		product.setName("hi");
		product.setCount(3);
		product.setPrice(7000);

		productRepository.save(product);
	}

}
