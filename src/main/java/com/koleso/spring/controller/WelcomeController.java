package com.koleso.spring.controller;

import com.koleso.spring.dto.Player;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/players")
public class WelcomeController {

    private final Player getplayer1;
    //PesronService service;
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    public WelcomeController(@Qualifier("getplayer1") Player getplayer1) {
        this.getplayer1 = getplayer1;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView modelAndView) {

        modelAndView.addObject("players", getplayer1);
        modelAndView.addObject("greetMess", "asdkjlfhasjkfdhjakshdjkashdkjas");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
