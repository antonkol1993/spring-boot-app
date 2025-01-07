package com.koleso.spring.service.playerService;

import com.koleso.spring.dto.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getPlayers();

    List<Player> getPlayers(int page, int pageSize);

    int getAllPlayersCount();

    Player getPlayerById(Long id);

    void addPlayer(Player player);

    void removePlayer(Long id);

    void updatePlayer(Player player);
}
