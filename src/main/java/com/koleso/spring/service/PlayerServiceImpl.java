package com.koleso.spring.service;

import com.koleso.spring.dto.Player;
import com.koleso.spring.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;


    @Override
    public List<Player> getPlayersFromPage(int page, int pageSize) {
        Page<Player> players = playerRepository.findAll(PageRequest.of(page-1, pageSize));
        return players.getContent();
    }

    @Override
    public int getAllPlayersCount() {
        return playerRepository.findAll().size();
    }

    @Override
    public Player getPlayerById(Long id) {
        Optional<Player> byId = playerRepository.findById(id);
        return byId.orElseThrow();
    }

    @Override
    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void removePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public void updatePlayer(Player player) {
        playerRepository.save(player);
    }
}
