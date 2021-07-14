package com.cloud.basic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Emp {
    @Id
    int empno;

    @Column(name = "ENAME")
    String eName;

    @Column(name = "JOB")
    String job;

    @Column(name = "MGR")
    Integer mgr;

    @Column(name = "HIREDATE")
    Date hireDate;

    @Column(name = "SAL")
    Integer sal;

    @Column(name = "COMM")
    Integer comm;

    @ManyToOne(fetch = FetchType.LAZY)
    Dept dept;
}
