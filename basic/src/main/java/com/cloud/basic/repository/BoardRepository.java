package com.cloud.basic.repository;

import com.cloud.basic.model.Board;
import com.cloud.basic.model.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
