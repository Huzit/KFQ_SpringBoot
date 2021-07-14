package com.cloud.basic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
}
