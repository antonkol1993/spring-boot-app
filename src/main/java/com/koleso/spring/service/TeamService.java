package com.koleso.spring.service;

import com.koleso.spring.dto.Team;

import java.util.List;

public interface TeamService {

    List<Team> getTeams(int page, int pageSize);

    int getAllTeamsCount();

    Team getTeamById(Long id);
    List<Team> getTeamByName(String name);

    void addTeam(Team team);

    void removeTeam(Long id);

    void updateTeam(Team team);
}
