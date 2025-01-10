package com.koleso.spring.controller;

import com.koleso.spring.dto.Person;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @RequestMapping()
    public List<Person> getPersons(ModelAndView modelAndView) {

    }
}
