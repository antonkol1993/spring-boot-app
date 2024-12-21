package com.koleso.spring.services;

import com.koleso.spring.dto.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getPlayers();

    Player getPlayer(Long id);

    void addPlayer(Player player);

    void removePlayer(Long id);

    void updatePlayer(Player player);
}
