package com.koleso.spring.controller;

import com.koleso.spring.dto.Player;
import com.koleso.spring.service.PlayerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/players")
@RequiredArgsConstructor
public class WelcomeController {

    private final PlayerService playerService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPlayers(ModelAndView modelAndView) {

        modelAndView.addObject("players", playerService.getPlayers());
        modelAndView.setViewName("getPlayers");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addPlayerGet(ModelAndView modelAndView) {
        Player player = new Player();
        player.setName("dsadasdsa");
        player.setAge(38);
        modelAndView.addObject("players", player);
        modelAndView.setViewName("form");
        return modelAndView;
    }
    @PostMapping("/add")
    public ModelAndView addPlayerPost(ModelAndView modelAndView) {

        return modelAndView;
    }


}
