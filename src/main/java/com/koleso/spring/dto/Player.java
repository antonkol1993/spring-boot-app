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
    private Position position;
    @ManyToOne
    private Country country;
    @ManyToOne
    private Team team;
}
