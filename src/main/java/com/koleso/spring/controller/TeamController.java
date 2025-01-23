package com.koleso.spring.controller;

import com.koleso.spring.dto.Team;
import com.koleso.spring.repository.TeamRepository;
import com.koleso.spring.service.GameService;
import com.koleso.spring.service.TeamService;
import com.koleso.spring.service.pagination.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

    private final PaginationService paginationService;
    private final TeamService teamService;
    private final GameService gameService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getTeams(@RequestParam (defaultValue = "1") int page, ModelAndView modelAndView)  {
        List<Team> teamFromPage = teamService.getTeamFromPage(page, paginationService.getPageSize());
        modelAndView.addObject("teams", teamFromPage);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("pageSize", paginationService.getPageSize());
        modelAndView.setViewName("team/getTeams");
        return modelAndView;
    }

}
