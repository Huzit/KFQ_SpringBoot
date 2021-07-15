package com.cloud.basic.repository;

import com.cloud.basic.model.Emp;
import com.cloud.basic.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
