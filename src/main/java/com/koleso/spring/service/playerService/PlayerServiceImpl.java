package com.koleso.spring.service.playerService;

import com.koleso.spring.dto.Player;
import com.koleso.spring.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PaginationService paginationService;

    @Override
    public List<Player> getPlayers() {
        int pageSize = paginationService.getPageSize();
        List<Player> players = playerRepository.findAll();
        int fromIndex = 0;
        int toIndex = fromIndex + pageSize;
        if (toIndex > players.size()) {
            toIndex = players.size();
        }
        players = players.subList(fromIndex, toIndex);
        return players;
    }

    @Override
    public List<Player> getPlayers(int page, int pageSize) {

        List<Player> players = playerRepository.findAll();
        int fromIndex = (page-1) * pageSize;
        int toIndex = fromIndex + pageSize;
        if (toIndex > players.size()) {
            toIndex = players.size();
        }
        players = players.subList(fromIndex, toIndex);
        return players;
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
