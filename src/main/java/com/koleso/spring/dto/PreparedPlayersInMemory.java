package com.koleso.spring.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.koleso.spring")
public class PreparedPlayersInMemory {

//    @Bean
//    @Scope(value = "prototype")
//    public Player playerMessi() {
//        Player player = new Player();
////        player.setName("Messi");
//        return player;
//    }
//    @Bean
//    @Scope(value = "prototype")
//    public Player playerRois() {
//        Player player = new Player();
////        player.setName("Rois");
//        return player;
//    }

    @Bean
    public static List<Player> getLocalePlayers() {
        return List.of(
                new Player().withName("Messi").withAge(35).withCountry("Argentina").withPosition("Forward").withRating("91"),
                new Player().withName("Rois").withAge(34).withCountry("Germany").withPosition("Midfielder").withRating("59"),
                new Player().withName("Hleb").withAge(38).withCountry("Belarus").withPosition("Midfielder").withRating("47"),
                new Player().withName("Mironchyk").withAge(29).withCountry("Russia").withPosition("Forward").withRating("53"),
                new Player().withName("Bensema").withAge(35).withCountry("France").withPosition("Forward").withRating("69"),
                new Player().withName("Lukaku").withAge(33).withCountry("Belgium").withPosition("Forward").withRating("57"),
                new Player().withName("Donnarumma").withAge(35).withCountry("Italy").withPosition("Goalkeeper").withRating("83"),
                new Player().withName("Narut").withAge(23).withCountry("USA").withPosition("Forward").withRating("96")

        );
    }
}
