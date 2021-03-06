package com.cloud.basic.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private String name;
    private String userid;
    private String userpassword;
}