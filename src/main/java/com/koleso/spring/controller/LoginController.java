package com.koleso.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String home() {
        return "login/home"; // Домашняя страница
    }

    @GetMapping("/login")
    public String login() {
        return "login/login"; // Страница входа
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "login/welcome"; // Страница приветствия
    }
}
