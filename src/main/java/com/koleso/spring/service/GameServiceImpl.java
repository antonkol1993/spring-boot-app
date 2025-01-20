package com.koleso.spring.service;

import com.koleso.spring.dto.Game;
import com.koleso.spring.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;


    @Override
    public List<Game> getGames(int page, int pageSize) {
        Page<Game> countries = gameRepository.findAll(PageRequest.of(page, pageSize));
        return countries.getContent();
    }

    @Override
    public int getAllGamesCount() {
        return gameRepository.findAll().size();
    }

    @Override
    public Game getGameById(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        return game.orElseThrow();
    }

    @Override
    public List<Game> getGameByName(String name) {
        return gameRepository.findAllByName(name);
    }

    @Override
    public void addGame(Game Game) {
        gameRepository.save(Game);
    }

    @Override
    public void removeGame(Long id) {
        gameRepository.deleteById(id);
    }

    @Override
    public void updateGame(Game game) {
        gameRepository.save(game);
    }
}
