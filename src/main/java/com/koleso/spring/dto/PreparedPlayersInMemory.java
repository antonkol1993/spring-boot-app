package com.koleso.spring.dto;

import lombok.AllArgsConstructor;

import java.util.List;

public class PreparedPlayersInMemory {

    public static List<Player> getPlayers() {
        Player player1 = new Player(2, "Messi", 35, "Argentina", "Attack", "92");
        Player player2 = new Player(3, "Maradonna", 55, "Argentina", "Attack", "72");
        Player player3 = new Player()
                .withId(4)
                .withName("Carlos")
                .withAge(50)
                .withCountry("Brazil")
                .withPosition("defender");
        return List.of(player1, player2, player3);
    }

}
