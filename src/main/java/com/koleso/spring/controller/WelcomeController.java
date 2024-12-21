package com.koleso.spring.controller;

import com.koleso.spring.dto.Player;
import com.koleso.spring.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/players")
@RequiredArgsConstructor
public class WelcomeController {

//    @Autowired
    private final PlayerService playerService;

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView modelAndView) {

        modelAndView.addObject("players", playerService.getPlayers());
        modelAndView.addObject("greetMess", "asdkjlfhasjkfdhjakshdjkashdkjas");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
