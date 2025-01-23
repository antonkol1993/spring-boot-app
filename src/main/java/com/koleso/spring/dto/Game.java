package com.koleso.spring.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id  ;
    private String name;

    @ManyToOne()
    Team homeTeam;

    @ManyToOne
    Team awayTeam;


}
