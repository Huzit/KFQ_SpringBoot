package com.cloud.basic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Order {
    @Id
    Integer id;

    String name;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
}
