package com.koleso.spring.controller;

import com.koleso.spring.dto.Player;
import com.koleso.spring.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


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
        modelAndView.addObject("players", player);
        modelAndView.setViewName("formAdd");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addPlayerPost(
            @RequestParam String name, @RequestParam String age, @RequestParam String country,
            @RequestParam String position, @RequestParam String rating, @RequestParam String team,
            ModelAndView modelAndView) {
        Player player = new Player();
        player.setName(name);
        player.setAge(Integer.parseInt(age));
        player.setCountry(country);
        player.setPosition(position);
        player.setRating(rating);
        playerService.addPlayer(player);
        modelAndView.addObject("players", playerService.getPlayers());
        modelAndView.setViewName("redirect:/players");
        return modelAndView;
    }

    @GetMapping("/get/*")
    public ModelAndView showPlayer(@RequestParam Long id, ModelAndView modelAndView) {
        modelAndView.addObject("player", playerService.getPlayerById(id));
        modelAndView.setViewName("showPlayer");
        return modelAndView;
    }


}
