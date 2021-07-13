package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Hospital {
    @Id
    int id;
    String sido;
    String name;
    int medical;
    int room;
    String tel;
    String address;
}
