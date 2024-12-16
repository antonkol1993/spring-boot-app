package com.koleso.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @RequestMapping( method = RequestMethod.GET, value = "/")
    public String welcome() {
        return "index";
    }
}
