package com.koleso.spring.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> player;

    @ManyToOne
    @JoinColumn (name = "country_id", referencedColumnName = "id")
    private Country country;

    @OneToMany(mappedBy = "awayTeam", cascade = CascadeType.ALL)
    private List<Game> awayGames;

    @OneToMany(mappedBy = "homeTeam", cascade = CascadeType.ALL)
    private List<Game> homeGames;


}
