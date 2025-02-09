package com.koleso.spring.dto;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "home_team")
    Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team")
    Team awayTeam;


}
