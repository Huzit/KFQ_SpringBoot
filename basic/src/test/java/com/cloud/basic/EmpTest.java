package com.cloud.basic;

import com.cloud.basic.repository.EmpRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpTest {
    @Autowired
    EmpRepository empRepository;

    @Test
    public void Tset(){
        System.out.println(empRepository.findAll());
    }
}
