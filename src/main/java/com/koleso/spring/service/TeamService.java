package com.koleso.spring.service;

import com.koleso.spring.dto.Team;

import java.util.List;

public interface TeamService {

    List<Team> getTeamFromPage(int page, int pageSize);
    List<Team> getAllTeams();

    int getAllTeamsCount();

    Team getTeamById(Long id);
    List<Team> getTeamByName(String name);

    void addTeam(Team team);

    void removeTeam(Long id);

    void updateTeam(Team team);
}
