package com.ggoreb.practice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;

@SpringBootTest
class PracticeApplicationTests {

	@Test
	void contextLoads(HttpSession session) {
		System.out.println(session.getAttribute("session"));
	}

}
