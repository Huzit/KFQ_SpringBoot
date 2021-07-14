package com.cloud.basic.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    int age;

    @ManyToOne(fetch = FetchType.LAZY)
    Team team;
}
