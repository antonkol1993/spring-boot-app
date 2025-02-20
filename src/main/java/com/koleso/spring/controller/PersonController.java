package com.koleso.spring.controller;

import com.koleso.spring.service.pagination.PaginationService;
import com.koleso.spring.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("pageSize", paginationService.getPageSize());
        modelAndView.setViewName("person/getPersons");
        return modelAndView;
    }

    @GetMapping("add")
    public ModelAndView addPersonGet(ModelAndView modelAndView) {
        modelAndView.setViewName("player/errorDataPlayer");
        return modelAndView;
    }

    @GetMapping("update/{id}")
    public ModelAndView updatePersonGet(
            ModelAndView modelAndView,
            @PathVariable Long id) {
        modelAndView.setViewName("player/errorDataPlayer");
        return modelAndView;
    }

    @GetMapping("remove/{id}")
    public ModelAndView removePersonGet(
            ModelAndView modelAndView,
            @PathVariable Long id) {
        modelAndView.setViewName("player/errorDataPlayer");
        return modelAndView;
    }


}
