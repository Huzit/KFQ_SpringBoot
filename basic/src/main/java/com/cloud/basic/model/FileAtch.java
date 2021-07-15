package com.cloud.basic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class FileAtch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String saveName;
    String originName;

    @ManyToOne
    Board board;
}
