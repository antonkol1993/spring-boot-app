package com.koleso.spring.service;

import com.koleso.spring.dto.Player;
import com.koleso.spring.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayer(Long id) {
        return null;
    }

    @Override
    public void addPlayer(Player player) {

    }

    @Override
    public void removePlayer(Long id) {

    }

    @Override
    public void updatePlayer(Player player) {

    }
}
