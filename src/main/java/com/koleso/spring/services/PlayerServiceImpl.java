package com.koleso.spring.services;

import com.koleso.spring.dto.Player;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON, proxyMode = ScopedProxyMode.INTERFACES)
public class PlayerServiceImpl implements PlayerService{

    @Override
    public List<Player> getPlayers() {
        return List.of();
    }

    @Override
    public Player getPlayer() {
        return null;
    }

    @Override
    public void addPlayers() {

    }

    @Override
    public void removePlayers() {

    }

    @Override
    public void editPlayers() {

    }
}
