package com.koleso.spring.service.player_service;

import com.koleso.spring.dto.Player;
import com.koleso.spring.repository.PlayerRepository;
import com.koleso.spring.service.pagination.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PaginationService paginationService;


    @Override
    public List<Player> getPlayers(int page, int pageSize) {

        Page<Player> players = playerRepository.findAll(PageRequest.of(page, pageSize));
        return players.getContent();
    }

    @Override
    public int getAllPlayersCount() {
        return playerRepository.findAll().size();
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow();
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
