package com.cloud.basic.controller;

import com.cloud.basic.model.Dept;
import com.cloud.basic.model.Emp;
import com.cloud.basic.repository.DeptRepository;
import com.cloud.basic.repository.EmpRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class EmpController {
    @Autowired
    EmpRepository empRepository;
    @Autowired
    DeptRepository deptRepository;

    @GetMapping("/emp")
    public List<Emp> emp(){

        return empRepository.findAll() ;
    }
    @GetMapping("/dept")
    public List<Dept> dept(){
        return deptRepository.findAll();
    }
}
