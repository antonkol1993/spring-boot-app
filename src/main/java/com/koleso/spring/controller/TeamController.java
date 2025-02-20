package com.koleso.spring.controller;

import com.koleso.spring.dto.*;
import com.koleso.spring.service.CountryService;
import com.koleso.spring.service.PersonService;
import com.koleso.spring.service.PlayerService;
import com.koleso.spring.service.TeamService;
import com.koleso.spring.service.pagination.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    private final PlayerService playerService;
    private final CountryService countryService;
    private final PersonService personService;
    private final UserDetailsService userDetailsService;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getTeams(
            @RequestParam(defaultValue = "1") int page,
            ModelAndView modelAndView) {
        List<Team> teamFromPage = teamService.getTeamFromPage(page, paginationService.getPageSize());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Убедитесь, что principal - это объект типа UserDetails (или User)
        Person personByUsername;
        if (principal instanceof UserDetails userDetails) {
            // Теперь можно работать с userDetails (например, получить имя пользователя)
            String username = userDetails.getUsername();
            // Действия с userDetails
            personByUsername = personService.getPersonByUsername(username);
            modelAndView.addObject("currentPerson", personByUsername);
        } else {
            // В случае, если principal не является экземпляром UserDetails
            System.out.println("Principal is not an instance of UserDetails");
        }
        modelAndView.addObject("teams", teamFromPage);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("pageSize", paginationService.getPageSize());
        modelAndView.addObject("pageCount", paginationService.getTotalPageCount(teamService.getAllTeamsCount()));
        modelAndView.setViewName("team/getTeams");
        return modelAndView;
    }

    @GetMapping("remove/{id}")
    public ModelAndView removeTeam(
            @PathVariable String id,
            ModelAndView modelAndView) {
        Long teamId = Long.valueOf(id);
        teamService.removeTeam(teamId);
        modelAndView.setViewName("redirect:/teams");
        return modelAndView;
    }

    @GetMapping("update/{id}")
    public ModelAndView updateTeamGet(
            @PathVariable String id,
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
            @PathVariable Long id,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String city,
            @RequestParam(defaultValue = "") String country,
            ModelAndView modelAndView) {
        Team teamById = teamService.getTeamById(id);
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
        if (!country.isEmpty()) {
            List<Country> countriesByName = countryService.getCountriesByName(country);
            team.setCountry(countriesByName.getFirst());
        }
        teamService.addTeam(team);
        modelAndView.setViewName("redirect:/teams");
        return modelAndView;
    }

    @GetMapping("update/players/{id}")
    public ModelAndView updatePlayersIntoTeamGet(
            @PathVariable String id,
            ModelAndView modelAndView) {
        Long teamId = Long.valueOf(id);
        Team teamObject = teamService.getTeamById(teamId);
        List<Player> allPlayers = playerService.getAllPlayers();
        List<Integer> setPlayers = new ArrayList<>();
        modelAndView.addObject("setPlayers", setPlayers);
        modelAndView.addObject("allPlayers", allPlayers);
        modelAndView.addObject("team", teamObject);
        modelAndView.setViewName("team/pageUpdatePlayersIntoTeam");
        return modelAndView;
    }


    @PostMapping("update/players/{id}")
    public ModelAndView updatePlayersIntoTeamPost(
            @PathVariable Long id,
            @RequestBody PlayerCollectionDTO playerCollection,
            ModelAndView modelAndView)  {

        Team teamById = teamService.getTeamById(id);
        List<Long> ids = playerCollection.getIds();
        List<Player> players = teamById.getPlayers();

        for (Player player : players) {
            if (player.getTeam().getId().equals(teamById.getId())) {
                player.setTeam(null);
                playerService.updatePlayer(player);
            }
        }
        players.clear();
        for (Long aLong : ids) {
            teamById.getPlayers().add(playerService.getPlayerById(aLong));
            Player player = playerService.getPlayerById(aLong);
            player.setTeam(teamById);
            playerService.updatePlayer(player);
        }

        teamService.updateTeam(teamById);
        modelAndView.setViewName("redirect:/teams/update/{id}");
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
