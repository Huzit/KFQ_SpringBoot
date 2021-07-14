package com.example.demo.controller;

import com.example.demo.model.Emp;
import com.example.demo.repository.EmpRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class EmpController {
    @Autowired
    EmpRepository empRepository;

    @GetMapping("/emp")
    public List<Emp> emp(){
        return empRepository.findAll();
    }

    @GetMapping("/emp/{sal}") //TODO Pathvariable 방식
    public List<Emp> empSal(@PathVariable("sal") int sal){
        return empRepository.findAllBySalGreaterThanEqual(sal);
    }

    @GetMapping("/emp/deptno") //TODO Pathvariable 방식
    //RequestParam을 쓰지 않고 패러미터만 넣어줘도 축약해서 사용가능하다
    public List<Emp> empDeptno(int deptno){
        return empRepository.findALLByDeptno(deptno);
    }
    @GetMapping("/emp/ename") //TODO Pathvariable 방식
    public List<Emp> empEname(String ename){
        return empRepository.findAllByEnameContainingOrderByEnameAsc(ename);
    }
}
