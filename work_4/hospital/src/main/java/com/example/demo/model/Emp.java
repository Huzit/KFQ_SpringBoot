package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Emp {
    @Id
    int empno;
    String job;
    String ename;
    Integer deptno;
    Integer sal;
}
