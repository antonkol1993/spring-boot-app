package com.koleso.spring.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String capitalCity;

    @OneToMany(mappedBy = "country")
    private List<Player> players;
    @OneToMany(mappedBy = "country")
    private List<Team> teams;

}
