package com.cloud.basic.repository;

import com.cloud.basic.model.Board;
import com.cloud.basic.model.FileAtch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileAtchRepository extends JpaRepository<FileAtch, Long> {
}
