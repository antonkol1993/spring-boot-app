package com.koleso.spring.objects;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    @Column(name = "logo_url")
    private String logoURL;
    @Column(name = "wiki_url")
    private String teamWikiURL;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players;

    @OneToMany(mappedBy = "awayTeam", cascade = CascadeType.ALL)
    private List<Game> awayGames;

    @OneToMany(mappedBy = "homeTeam", cascade = CascadeType.ALL)
    private List<Game> homeGames;

    @OneToOne(mappedBy = "team", cascade = CascadeType.ALL)
    private Person manager;
}


