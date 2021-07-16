package com.example.board.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String pwd;
    private String name;
}
