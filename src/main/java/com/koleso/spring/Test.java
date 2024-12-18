package com.koleso.spring;

import com.koleso.spring.dto.Player;
import com.koleso.spring.dto.PreparedPlayersInMemory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Player.class);
        context.register(PreparedPlayersInMemory.class);
        context.refresh();
        context.start();
        Player playerMessi = context.getBean(Player.class,"playerMessi");
        Player playerRois = context.getBean(Player.class, "playerRois");

        System.out.println(playerMessi);
        System.out.println(playerRois);


//
//        Player player1 = new Player();
//        player1.setName("Rois");
//        Player player2 = new Player();
//        player2.setName("Hleb");
//        Player player3 = new Player();
//        player3.setName("Mironchyk");
//        Player player4 = new Player();
//        player4.setName("Bensema");
//        Player player5 = new Player();
//        player5.setName("Lukaku");
//        Player player6 = new Player();
//        player6.setName("Donnarumma");
//        Player player7 = new Player();
//        player7.setName("Narut");
//        List<Player> getLocalePlayers = List.of(
//            player0,player1,player2,player3,player4,player5,player6,player7
//
//            );
//
//        for (int i = 0; i < getLocalePlayers.size(); i++) {
//            System.out.println(getLocalePlayers.get(i).getName());
//
//        }

//        for (int i = 0; i < PreparedPlayersInMemory.getLocalePlayers().size(); i++) {
//            List<Player> localePlayers = PreparedPlayersInMemory.getLocalePlayers();
//            System.out.println(localePlayers.get(i));
//
//        }
    }
}
