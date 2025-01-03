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

    @Override
    public List<Player> getPlayers() {
//        playerRepository.findByAgeLessThanEqualAndPosition(40, "forward")
//                .ifPresent(players -> players.forEach(System.out::println));
//        playerRepository.findAll(PageRequest.of(5, 30, Sort.Direction.ASC, "age"));
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
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

    }
}
