package com.example.demo;

import com.example.demo.repository.HospitalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalApplicationTests {
	@Autowired
	HospitalRepository hos;

	@Test
	void contextLoads() {
		System.out.println(hos.findAll());
	}

}
