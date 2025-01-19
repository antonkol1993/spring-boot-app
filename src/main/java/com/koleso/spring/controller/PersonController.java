package com.koleso.spring.controller;

import com.koleso.spring.service.pagination.PaginationService;
import com.koleso.spring.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;
    private final PaginationService paginationService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPersons(@RequestParam(value = "page", defaultValue = "1") int page, ModelAndView modelAndView) {
        modelAndView.addObject("persons", personService.getPersons(page, paginationService.getPageSize()));
        modelAndView.addObject("pageCount", paginationService.getTotalPageCount(personService.getAllPersonsCount()));
        modelAndView.setViewName("person/getPersons");
        return modelAndView;
    }
}
