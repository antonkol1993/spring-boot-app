package com.koleso.spring.service;

import com.koleso.spring.dto.Team;
import com.koleso.spring.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;


    @Override
    public List<Team> getTeamFromPage(int page, int pageSize) {
        Page<Team> teams = teamRepository.findAll(PageRequest.of(page, pageSize));
        return teams.getContent();
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public int getAllTeamsCount() {
        return teamRepository.findAll().size();
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
    teamRepository.deleteById(id);
    }

    @Override
    public void updateTeam(Team team) {
        teamRepository.save(team);
    }
}
