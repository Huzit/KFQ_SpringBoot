package com.cloud.basic.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Dept {
    @Id
    int deptno;
    @Column(name = "DNAME")
    String dName;
    @Column(name = "LOC")
    String loc;
}
