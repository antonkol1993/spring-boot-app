package com.koleso.spring.controller;

import com.koleso.spring.dto.PreparedPlayersInMemory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/players")
public class WelcomeController {

    //PesronService service;


    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView modelAndView) {

        modelAndView.addObject("players", PreparedPlayersInMemory.getplayer1());
        modelAndView.addObject("greetMess", "asdkjlfhasjkfdhjakshdjkashdkjas");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
