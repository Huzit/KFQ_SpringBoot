package com.cloud.basic;

import com.cloud.basic.model.Player;
import com.cloud.basic.model.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@SpringBootTest
class ModelTest {
    @Autowired
    EntityManagerFactory emf;

    @Test
    void test() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team); // 팀 저장
            Player member = new Player();
            member.setName("member1");
            member.setTeam(team); // 단방향 연관관계 설정
            em.persist(member);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

}

