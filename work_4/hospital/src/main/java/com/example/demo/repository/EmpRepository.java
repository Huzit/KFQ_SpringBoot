package com.example.demo.repository;

import com.example.demo.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
    List<Emp> findAllBySalGreaterThanEqual(int sal);
    List<Emp> findALLByDeptno(int deptno);
    List<Emp> findAllByEnameContainingOrderByEnameAsc(String ename);
}
