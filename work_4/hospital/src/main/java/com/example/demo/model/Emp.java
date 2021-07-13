package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Emp {
    @Id
    int EMPNO;
    String JOB;
    String ENAME;
}
