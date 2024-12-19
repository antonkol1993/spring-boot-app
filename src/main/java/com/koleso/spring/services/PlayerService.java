package com.koleso.spring.services;

import com.koleso.spring.dto.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getPlayers();
    Player getPlayer();
    void addPlayers();
    void removePlayers();
    void editPlayers();
}
