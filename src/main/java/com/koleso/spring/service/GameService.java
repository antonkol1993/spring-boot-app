package com.koleso.spring.service;

import com.koleso.spring.dto.Game;

import java.util.List;

public interface GameService {

    List<Game> getGames(int page, int pageSize);

    int getAllGamesCount();

    Game getGameById(Long id);

    List<Game> getGameByName(String name);

    void addGame(Game Game);

    void removeGame(Long id);

    void updateGame(Game game);
}
