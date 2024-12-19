package com.koleso.spring.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@ComponentScan("com.koleso.spring")
@Component
public class PreparedPlayersInMemory {

    @Bean
    public static Player getplayer1(){
        Player player1 = new Player();
                player1.setName("Messi");
        return player1;
    }

//    public static List<Player> getLocalePlayers() {
//        Player player1 = new Player();
//        player1.setName("Messi");
//        Player player2 = new Player();
//        player2.setName("Hleb");
//        Player player3 = new Player();
//        player3.setName("Mironchyk");
//        return List.of(
//            player1,player2,player3
//
//        );
//    }



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
}