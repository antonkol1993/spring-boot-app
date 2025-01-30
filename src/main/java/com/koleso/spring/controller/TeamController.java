package com.koleso.spring.controller;

import com.koleso.spring.dto.*;
import com.koleso.spring.service.CountryService;
import com.koleso.spring.service.GameService;
import com.koleso.spring.service.PlayerService;
import com.koleso.spring.service.TeamService;
import com.koleso.spring.service.pagination.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

    private final PaginationService paginationService;
    private final TeamService teamService;
    private final GameService gameService;
    private final PlayerService playerService;
    private final CountryService countryService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getTeams(@RequestParam(defaultValue = "1") int page, ModelAndView modelAndView) {
        List<Team> teamFromPage = teamService.getTeamFromPage(page, paginationService.getPageSize());
        modelAndView.addObject("teams", teamFromPage);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("pageSize", paginationService.getPageSize());
        modelAndView.addObject("pageCount", paginationService.getTotalPageCount(teamService.getAllTeamsCount()));
        modelAndView.setViewName("team/getTeams");
        return modelAndView;
    }

    @GetMapping("remove/{id}")
    public ModelAndView removeTeam(@PathVariable String id, ModelAndView modelAndView) {
        Long teamId = Long.valueOf(id);
        teamService.removeTeam(teamId);
        modelAndView.setViewName("redirect:/teams");
        return modelAndView;
    }

    @GetMapping("update/{id}")
    public ModelAndView updateTeamGet(
            @PathVariable String id,
            @RequestParam (defaultValue = "numberOfPlayers")String numberOfPlayers,
            ModelAndView modelAndView) {
        Long teamId = Long.valueOf(id);
        Team teamById = teamService.getTeamById(teamId);
        List<Country> countries = countryService.getAllCountries();
        countries.addFirst(null);

        modelAndView.addObject("countries", countries);
        modelAndView.addObject("team", teamById);
        modelAndView.setViewName("team/formUpdate");
        return modelAndView;
    }

    @PostMapping("update/{id}")
    public ModelAndView updateTeamPost(
            @PathVariable String id,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String city,
            @RequestParam(defaultValue = "") String country,
            ModelAndView modelAndView) {
        Long teamId = Long.valueOf(id);
        Team teamById = teamService.getTeamById(teamId);
        if (name.isEmpty()) {
            modelAndView.setViewName("team/errorDataTeam");
            return modelAndView;
        } else {
            teamById.setName(name);
        }
        if (city.isEmpty()) {
            teamById.setCity(null);
        } else {
            teamById.setCity(city);
        }
        if (!country.isEmpty()) {
            List<Country> countryByName = countryService.getCountriesByName(country);
            teamById.setCountry(countryByName.getFirst());
        } else {
            teamById.setCountry(null);
        }
        teamService.updateTeam(teamById);
        modelAndView.setViewName("redirect:/teams");
        return modelAndView;
    }

    @GetMapping("add")
    public ModelAndView addTeamGet(ModelAndView modelAndView) {
        Team team = new Team();
        List<Country> countries = countryService.getAllCountries();
        countries.addFirst(null);

        modelAndView.addObject("team", team);
        modelAndView.addObject("countries", countries);
        modelAndView.setViewName("team/formAdd");
        return modelAndView;
    }

    @PostMapping("add")
    public ModelAndView addTeamPost(
            @RequestParam String name,
            @RequestParam String city,
            @RequestParam String country,
            ModelAndView modelAndView) {
        Team team = new Team();
        if (!name.isEmpty()) {
            team.setName(name);
        }
        if (!city.isEmpty()) {
            team.setCity(city);
        }
        if(!country.isEmpty()) {
            List<Country> countriesByName = countryService.getCountriesByName(country);
            team.setCountry(countriesByName.getFirst());
        }
        teamService.addTeam(team);
        modelAndView.setViewName("redirect:/teams");
        return modelAndView;
    }


//    @GetMapping("update/games/{id}")
//    public ModelAndView updateGamesIntoTeamGet(
//            @PathVariable String id,
//            ModelAndView modelAndView) {
//
//            Long teamId = Long.valueOf(id);
//            Team teamObject = teamService.getTeamById(teamId);
//            List<Game> awayGames = teamObject.getAwayGames();
//            List<Game> homeGames = teamObject.getHomeGames();
//
//            modelAndView.addObject("awayGames", awayGames);
//            modelAndView.addObject("homeGames", homeGames);
//            modelAndView.setViewName("team/pageUpdateGamesIntoTeam");
//            return modelAndView;
//
//    }
//
//    @PostMapping("update/games/{id}")
//    public ModelAndView updateGamesIntoTeamPost(
//            @PathVariable String id,
//            ModelAndView modelAndView) {
//        return modelAndView;
//    }


    @GetMapping("update/players/{id}")
    public ModelAndView updatePlayersIntoTeamGet(
            @RequestParam String id,
            ModelAndView modelAndView) {
            Long teamId = Long.valueOf(id);
            Team teamObject = teamService.getTeamById(teamId);
            List<Player> allPlayers = playerService.getAllPlayers();
            List<Integer> setPlayers = new ArrayList<Integer>();
        modelAndView.addObject("setPlayers", setPlayers);
            modelAndView.addObject("allPlayers", allPlayers);
            modelAndView.addObject("team", teamObject);
            modelAndView.setViewName("team/pageUpdatePlayersIntoTeam");
            return modelAndView;
        }

    @PostMapping("update/players/{id}")
    public ModelAndView updatePlayersIntoTeamPost(
            @PathVariable String id,
            ModelAndView modelAndView) {

        return modelAndView;
    }



    @GetMapping("get/{id}")
    public ModelAndView getTeamById(
            ModelAndView modelAndView,
            @PathVariable String id) {
        Long teamId = Long.valueOf(id);
        modelAndView.addObject("team", teamService.getTeamById(teamId));
        modelAndView.setViewName("team/showTeam");
        return modelAndView;
    }




}
