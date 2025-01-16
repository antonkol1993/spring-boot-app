package com.koleso.spring.service.team_service;

import com.koleso.spring.dto.Team;
import com.koleso.spring.repository.TeamRepository;
import com.koleso.spring.service.pagination_service.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final PaginationService paginationService;


    @Override
    public List<Team> getTeams(int page, int pageSize) {
        return List.of();
    }

    @Override
    public int getAllTeamsCount() {
        return 0;
    }

    @Override
    public Team getTeamById(Long id) {
        Optional<Team> teamById = teamRepository.findById(id);
        return teamById.orElseThrow();
    }

    @Override
    public List<Team> getTeamByName(String name) {
        return teamRepository.findAllByName(name);
    }

    @Override
    public void addTeam(Team team) {
       teamRepository.save(team);
    }

    @Override
    public void removeTeam(Long id) {

    }

    @Override
    public void updateTeam(Team team) {

    }
}
