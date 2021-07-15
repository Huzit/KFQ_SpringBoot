package com.cloud.basic.model;

import jdk.dynalink.linker.LinkerServices;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;

    @OneToMany(mappedBy = "team")
    List<Player> players = new ArrayList<>();
}
