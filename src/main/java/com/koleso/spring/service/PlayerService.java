package com.koleso.spring.service;

import com.koleso.spring.dto.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getPlayers(int page, int pageSize);

    int getAllPlayersCount();

    Player getPlayerById(Long id);

    void addPlayer(Player player);

    void removePlayer(Long id);

    void updatePlayer(Player player);
}
