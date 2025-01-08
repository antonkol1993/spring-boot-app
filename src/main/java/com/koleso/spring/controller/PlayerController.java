package com.koleso.spring.controller;

import com.koleso.spring.dto.Player;
import com.koleso.spring.service.playerService.PaginationService;
import com.koleso.spring.service.playerService.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;
    private final PaginationService paginationService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPlayers(@RequestParam(value = "page", defaultValue = "1") int page, ModelAndView modelAndView) {
        modelAndView.addObject("players", playerService.getPlayers(page, paginationService.getPageSize()));
        modelAndView.addObject("pageCount", paginationService.getTotalPageCount(playerService.getAllPlayersCount()));
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
        player.setTeam(Integer.valueOf(team));
        playerService.addPlayer(player);
        modelAndView.addObject("players", playerService.getPlayers());
        modelAndView.setViewName("redirect:/players");
        return modelAndView;
    }

    @GetMapping("get/*")
    public ModelAndView getPlayerById(@RequestParam(value = "param") String id, ModelAndView modelAndView) {
        Long playerId = Long.valueOf(id);
        modelAndView.addObject("player", playerService.getPlayerById(playerId));
        modelAndView.setViewName("showPlayer");
        return modelAndView;
    }

    @GetMapping("remove/*")
    public ModelAndView removePlayer(@RequestParam(value = "id") String id, ModelAndView modelAndView) {
        Long playerId = Long.valueOf(id);
        playerService.removePlayer(playerId);
        modelAndView.addObject("players", playerService.getPlayers());
        modelAndView.setViewName("redirect:/players");
        return modelAndView;
    }


    @GetMapping("update/*")
    public ModelAndView editPlayerGet(@RequestParam(value = "id") String id, ModelAndView modelAndView) {
        Long playerId = Long.valueOf(id);
        Player player = playerService.getPlayerById(playerId);
        modelAndView.addObject("player", player);
        modelAndView.setViewName("formUpdate");
        return modelAndView;
    }


    @PostMapping("update/*")
    public ModelAndView editPlayerPost(
            @RequestParam String name, @RequestParam String age, @RequestParam String country,
            @RequestParam String position, @RequestParam String rating, @RequestParam String team,
            @RequestParam(value = "id") String id, ModelAndView modelAndView) {
        Long playerId = Long.valueOf(id);
        Player player = playerService.getPlayerById(playerId);
        player.setName(name);
        player.setAge(Integer.parseInt(age));
        player.setCountry(country);
        player.setPosition(position);
        player.setRating(rating);
        player.setTeam(Integer.valueOf(team));
        playerService.updatePlayer(player);

        modelAndView.addObject("players", playerService.getPlayers());
        modelAndView.setViewName("redirect:/players");
        return modelAndView;
    }


}
