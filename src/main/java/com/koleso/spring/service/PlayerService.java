package com.koleso.spring.service;

import com.koleso.spring.dto.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getPlayers();

    Player getPlayerById(Long id);

    void addPlayer(Player player);

    void removePlayer(Long id);

    void updatePlayer(Player player);
}
