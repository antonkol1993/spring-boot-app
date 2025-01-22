package com.koleso.spring.controller;

import com.koleso.spring.dto.Country;
import com.koleso.spring.dto.Player;
import com.koleso.spring.dto.Position;
import com.koleso.spring.dto.Team;
import com.koleso.spring.service.*;
import com.koleso.spring.service.pagination.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {
    private final CountryService countryService;
    private final GameService gameService;
    private final PlayerService playerService;
    private final PositionService positionService;
    private final TeamService teamService;
    private final PaginationService paginationService;

    //+++++++++
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPlayers(@RequestParam(value = "page", defaultValue = "1") int page, ModelAndView modelAndView) {
        modelAndView.addObject("players", playerService.getPlayersFromPage(page, paginationService.getPageSize()));
        modelAndView.addObject("pageCount", paginationService.getTotalPageCount(playerService.getAllPlayersCount()));
        modelAndView.addObject("currentPage", page);
        modelAndView.setViewName("player/getPlayers");
        return modelAndView;
    }

    //+++++++++
    @GetMapping("add")
    public ModelAndView addPlayerGet(ModelAndView modelAndView) {
        Player player = new Player();
        List<Country> countries = countryService.getAllCountries();
        countries.addFirst(null);
        List<Position> positions = positionService.getAllPositions();
        positions.addFirst(null);
        List<Team> teams = teamService.getAllTeams();
        teams.addFirst(null);
        modelAndView.addObject("players", player);
        modelAndView.addObject("countries", countries);
        modelAndView.addObject("positions", positions);
        modelAndView.addObject("teams", teams);
        modelAndView.setViewName("player/formAdd");
        return modelAndView;
    }

    //+++++++++
    @PostMapping("add")
    public ModelAndView addPlayerPost(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") String age,
            @RequestParam String country,
            @RequestParam String position,
            @RequestParam(defaultValue = "0") String rating,
            @RequestParam String team,
            ModelAndView modelAndView) {
        Player player = new Player();
        if (name.isEmpty()) {
            modelAndView.setViewName("player/errorDataPlayer");
            return modelAndView;
        }
        player.setName(name);
        int intAge = Integer.parseInt(age);
        if (intAge > 0) {
            player.setAge(Integer.parseInt(age));
        }
        if (!country.isEmpty()) {
            List<Country> countryByName = countryService.getCountriesByName(country);
            player.setCountry(countryByName.getFirst());
        }
        if (!country.isEmpty()) {
            List<Position> positionByName = positionService.getPositionByName(position);
            player.setPosition(positionByName.getFirst());
        }
        int intRating = Integer.parseInt(rating);
        if (intRating > 0) {
            player.setRating(rating);
        }
        if (!team.isEmpty()) {
            List<Team> teamByName = teamService.getTeamByName(team);
            player.setTeam(teamByName.getFirst());
        }
        playerService.addPlayer(player);
        modelAndView.addObject("players", playerService.getPlayersFromPage(1, paginationService.getPageSize()));
        modelAndView.setViewName("redirect:/players");
        return modelAndView;
    }

    //+++++++++
    @GetMapping("get")
    public ModelAndView getPlayerById(@RequestParam String id, ModelAndView modelAndView) {
        Long playerId = Long.valueOf(id);
        modelAndView.addObject("player", playerService.getPlayerById(playerId));
        modelAndView.setViewName("player/showPlayer");
        return modelAndView;
    }

    @GetMapping("remove")
    public ModelAndView removePlayer(@RequestParam(value = "{id}") String id, ModelAndView modelAndView) {
        Long playerId = Long.valueOf(id);
        playerService.removePlayer(playerId);
        modelAndView.addObject("players", playerService.getPlayersFromPage(1, paginationService.getPageSize()));
        modelAndView.setViewName("redirect:/players");
        return modelAndView;
    }


    @GetMapping("update{id}")
    public ModelAndView editPlayerGet(@RequestParam String id, ModelAndView modelAndView) {
        Long playerId = Long.valueOf(id);
        Player player = playerService.getPlayerById(playerId);
        List<Country> countries = countryService.getAllCountries();
        countries.addFirst(null);
        List<Position> positions = positionService.getAllPositions();
        positions.addFirst(null);
        List<Team> teams = teamService.getAllTeams();
        teams.addFirst(null);
        modelAndView.addObject("player", player);
        modelAndView.addObject("countries", countries);
        modelAndView.addObject("positions", positions);
        modelAndView.addObject("teams", teams);
        modelAndView.setViewName("player/formUpdate");
        return modelAndView;
    }


    @PostMapping("update{id}")
    public ModelAndView editPlayerPost(
            @RequestParam(value = "id") String id,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "0") String age,
            @RequestParam(defaultValue = "") String country,
            @RequestParam(defaultValue = "") String position,
            @RequestParam(defaultValue = "0") String rating,
            @RequestParam(defaultValue = "") String team,
            ModelAndView modelAndView) {
        Long playerId = Long.valueOf(id);
        Player player = playerService.getPlayerById(playerId);
        if (name.isEmpty()) {
            modelAndView.setViewName("player/errorDataPlayer");
            return modelAndView;
        } else {
            player.setName(name);
        }
        int intAge = Integer.parseInt(age);
        if (intAge > 0) {
            player.setAge(Integer.parseInt(age));
        } else {
            player.setAge(null);
        }
        if (!country.isEmpty()) {
            List<Country> countryByName = countryService.getCountriesByName(country);
            player.setCountry(countryByName.getFirst());
        } else {
            player.setCountry(null);
        }
        if (!position.isEmpty()) {
            List<Position> positionByName = positionService.getPositionByName(position);
            player.setPosition(positionByName.getFirst());
        } else {
            player.setPosition(null);
        }
        int intRating = Integer.parseInt(rating);
        if (intRating > 0) {
            player.setRating(rating);
        } else {
            player.setRating(null);
        }
        if (!team.isEmpty()) {
            List<Team> teamByName = teamService.getTeamByName(team);
            player.setTeam(teamByName.getFirst());
        } else {
            player.setTeam(null);
        }
        playerService.updatePlayer(player);
        modelAndView.setViewName("redirect:/players");
        return modelAndView;
    }


}
