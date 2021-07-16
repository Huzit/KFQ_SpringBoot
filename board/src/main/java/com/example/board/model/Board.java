package com.example.board.model;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String title;
    private String content;
    private String userId;

}
