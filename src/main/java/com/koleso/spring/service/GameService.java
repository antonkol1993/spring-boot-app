package com.koleso.spring.service;

import com.koleso.spring.objects.Game;

import java.util.List;

public interface GameService {

    List<Game> getGamesFromPage(int page, int pageSize);

    List<Game> getAllGames();

    int getAllGamesCount();

    Game getGameById(Long id);

    List<Game> getGameByName(String name);

    void addGame(Game Game);

    void removeGame(Long id);

    void updateGame(Game game);
}
