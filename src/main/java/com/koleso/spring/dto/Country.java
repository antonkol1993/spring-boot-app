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
    private Long id;
    private String name;
    private String capitalCity;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Player> players;
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Team> teams;

}
