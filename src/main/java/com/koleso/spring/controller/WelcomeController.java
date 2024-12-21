package com.koleso.spring.controller;

import com.koleso.spring.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/players")
@RequiredArgsConstructor
public class WelcomeController {

    private final PlayerService playerService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView modelAndView) {

        modelAndView.addObject("players", playerService.getPlayers());
        modelAndView.addObject("greetMess", "asdkjlfhasjkfdhjakshdjkashdkjas");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
