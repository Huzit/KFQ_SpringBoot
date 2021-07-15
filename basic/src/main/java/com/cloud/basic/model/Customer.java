package com.cloud.basic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Customer {
    @Id
    String id;
    String name;
    Integer age;
}
