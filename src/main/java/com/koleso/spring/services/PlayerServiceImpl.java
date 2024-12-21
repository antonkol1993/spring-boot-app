package com.koleso.spring.services;

import com.koleso.spring.dto.Player;
import com.koleso.spring.dto.PreparedPlayersInMemory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON, proxyMode = ScopedProxyMode.INTERFACES)
public class PlayerServiceImpl implements PlayerService {

    @Override
    public List<Player> getPlayers() {
        return PreparedPlayersInMemory.getPlayers();
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
