package com.koleso.spring.controller;

import com.koleso.spring.dto.Country;
import com.koleso.spring.dto.Team;
import com.koleso.spring.service.CountryService;
import com.koleso.spring.service.GameService;
import com.koleso.spring.service.TeamService;
import com.koleso.spring.service.pagination.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

    private final PaginationService paginationService;
    private final TeamService teamService;
    private final GameService gameService;
    private final CountryService countryService;

    //+++++++++
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

    //+++++++++
    @GetMapping("remove{id}")
    public ModelAndView removeTeam(@RequestParam String id, ModelAndView modelAndView) {
        Long teamId = Long.valueOf(id);
        teamService.removeTeam(teamId);
        modelAndView.setViewName("redirect:/teams");
        return modelAndView;
    }

    @GetMapping("update{id}")
    public ModelAndView updateTeamGet(@RequestParam String id, ModelAndView modelAndView) {
        Long teamId = Long.valueOf(id);
        Team teamById = teamService.getTeamById(teamId);
        List<Country> countries = countryService.getAllCountries();
        countries.addFirst(null);

        modelAndView.addObject("countries", countries);
        modelAndView.addObject("team", teamById);
        modelAndView.setViewName("team/formUpdate");
        return modelAndView;
    }

    @PostMapping("update{id}")
    public ModelAndView updateTeamGetPost(
            @RequestParam(defaultValue = "") String id,
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


}
