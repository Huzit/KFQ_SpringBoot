package com.cloud.basic.repository;

import com.cloud.basic.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository2 extends JpaRepository<Product, Long>{
}