package com.cloud.basic;

import static org.junit.jupiter.api.Assertions.*;

import com.cloud.basic.model.Player;
import com.cloud.basic.model.Product;
import com.cloud.basic.model.Team;
import com.cloud.basic.repository.PlayerRepository;
import com.cloud.basic.repository.ProductRepository;
import com.cloud.basic.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ProductRepositoryTest {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	TeamRepository teamRepository;
	@Autowired
	PlayerRepository playerRepository;
	
	//팀도 새로 만들고 플레이어도 새로 만들때
	@Test
	public void something(){
		Team t = new Team();
		teamRepository.save(t);

		Player p = new Player();
		p.setName("Hong");
		p.setTeam(t);
		playerRepository.save(p);
	}

	//기존의 팀에 새로운 플레이어 만들떄
	@Test
	public void something2(){
		Optional<Team> t = teamRepository.findById(36L);
		Team t2 = t.get();
		
		Player p = new Player();
		p.setName("Kong");
		p.setTeam(t2);
		playerRepository.save(p);
	}

	//옵셔널타입으로 받을 때
	@Test
	public void something3(){
		Optional<Player> opt = playerRepository.findById(39L);
		Player p = opt.get(); //조회결과가 없다면 예외로 발생
		System.out.println(p.getTeam().getName());
	}

	@Test
	void getTest(){
		System.out.println("testsetsetsetset");
	}

	@Test
	void addProduct() {
		Product product = new Product();
		product.setName("hi");
		product.setCount(3);
		product.setPrice(7000);

		productRepository.save(product);
	}

}
