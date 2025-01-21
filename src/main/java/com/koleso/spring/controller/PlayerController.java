package com.koleso.spring.controller;

import com.koleso.spring.dto.Country;
import com.koleso.spring.dto.Player;
import com.koleso.spring.dto.Team;
import com.koleso.spring.service.*;
import com.koleso.spring.service.pagination.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPlayers(@RequestParam(value = "page", defaultValue = "1") int page, ModelAndView modelAndView) {
        modelAndView.addObject("players", playerService.getPlayers(page, paginationService.getPageSize()));
        modelAndView.addObject("pageCount", paginationService.getTotalPageCount(playerService.getAllPlayersCount()));
        modelAndView.addObject("currentPage", page);
        modelAndView.setViewName("player/getPlayers");
        return modelAndView;
    }

    @GetMapping("add")
    public ModelAndView addPlayerGet(ModelAndView modelAndView) {
        Player player = new Player();
        List<Country> countries = countryService.getAllCountries();
        countries.addFirst(new Country());
        modelAndView.addObject("players", player);
        modelAndView.addObject("countries", countries);
        modelAndView.setViewName("player/formAdd");
        return modelAndView;
    }

    @PostMapping("add")
    public ModelAndView addPlayerPost(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") String age,
            @RequestParam String country,
//            @RequestParam String position,
//            @RequestParam String rating,
//            @RequestParam String team,
            ModelAndView modelAndView) {
        Player player = new Player();
        if (name.isEmpty()) {
            modelAndView.setViewName("player/errorDataPlayer");
            return modelAndView;
        }
        player.setName(name);
        int intAge = Integer.parseInt(age);
        if (intAge != 0) {
            player.setAge(Integer.parseInt(age));
        }
//        player.setCountry(country);
//        player.setPosition(position);
//        player.setRating(rating);
//        if (teamService.getTeamByName(team).isEmpty()) {
//            Team newTeam = new Team();
//            teamService.addTeam(newTeam);
//            newTeam.setName(team);
//            player.setTeam(newTeam);
//        } else {
//            Team currentFirstTeam = teamService.getTeamByName(team).getFirst();
//            player.setTeam(currentFirstTeam);
//        }
        playerService.addPlayer(player);
        modelAndView.addObject("players", playerService.getPlayers(1, paginationService.getPageSize()));
        modelAndView.setViewName("redirect:/players");
        return modelAndView;
    }

    @GetMapping("get")
    public ModelAndView getPlayerById(@RequestParam String id, ModelAndView modelAndView) {
        Long playerId = Long.valueOf(id);
        modelAndView.addObject("player", playerService.getPlayerById(playerId));
        modelAndView.setViewName("player/showPlayer");
        return modelAndView;
    }

    @GetMapping("remove")
    public ModelAndView removePlayer(@RequestParam (value = "{id}")String id, ModelAndView modelAndView) {
        Long playerId = Long.valueOf(id);
        playerService.removePlayer(playerId);
        modelAndView.addObject("players", playerService.getPlayers(1, paginationService.getPageSize()));
        modelAndView.setViewName("redirect:/players");
        return modelAndView;
    }


    @GetMapping("update{id}")
    public ModelAndView editPlayerGet(@RequestParam String id, ModelAndView modelAndView) {
        Long playerId = Long.valueOf(id);
        Player player = playerService.getPlayerById(playerId);
        modelAndView.addObject("player", player);
        modelAndView.setViewName("player/formUpdate");
        return modelAndView;
    }


    @PostMapping("update{id}")
    public ModelAndView editPlayerPost(
            @RequestParam String id,
            @RequestParam String name, @RequestParam String age, @RequestParam String country,
            @RequestParam String position, @RequestParam String rating,
            @RequestParam String team,
            ModelAndView modelAndView) {
        Long playerId = Long.valueOf(id);
        Player player = playerService.getPlayerById(playerId);
        player.setName(name);
        player.setAge(Integer.parseInt(age));
//        player.setCountry(country);
//        player.setPosition(position);
        player.setRating(rating);
        if (teamService.getTeamByName(team).isEmpty()) {
            modelAndView.addObject("player", player);
            modelAndView.setViewName("redirect:/errorDataPlayer.html");
        } else {
            Team currentFirstTeam = teamService.getTeamByName(team).getFirst();
            player.setTeam(currentFirstTeam);
        }
        player.getTeam().setName(team);
        playerService.updatePlayer(player);

        modelAndView.addObject("players", playerService.getPlayers(1, paginationService.getPageSize()));
        modelAndView.setViewName("redirect:/players");
        return modelAndView;
    }


}
