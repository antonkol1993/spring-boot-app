package com.koleso.spring.dto;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id  ;
    private String name;
    private Integer age;

    private String rating;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;


    private String imageURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b4/Lionel-Messi-Argentina-2022-FIFA-World-Cup_%28cropped%29.jpg/250px-Lionel-Messi-Argentina-2022-FIFA-World-Cup_%28cropped%29.jpg";

    private String wikiURL;
}
