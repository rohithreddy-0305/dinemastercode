package com.example.dinemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.service.ChefJpaService;

@RestController
public class ChefController {

    @Autowired
    private ChefJpaService chefService;

    @GetMapping("/restaurants/chefs")
    public ArrayList<Chef> getChefs() {
        return chefService.getAllChefs();
    }

    @PostMapping("/restaurants/chefs")
    public Chef addChef(@RequestBody Chef chef) {
        return chefService.addChef(chef);
    }

    @GetMapping("/restaurants/chefs/{chefId}")
    public Chef getChef(@PathVariable("chefId") int chefId) {
        return chefService.getChefById(chefId);
    }

    @PutMapping("/restaurants/chefs/{chefId}")
    public Chef getChef(@PathVariable("chefId") int chefId, @RequestBody Chef chef) {
        return chefService.updateChef(chefId, chef);
    }

    @DeleteMapping("/restaurants/chefs/{chefId}")
    public void deleteChef(@PathVariable("chefId") int chefId) {
        chefService.deleteChef(chefId);
    }

    @GetMapping("/chefs/{chefId}/restaurant")
    public Restaurant getRestaurant(@PathVariable("chefId") int chefId) {
        return chefService.getRestaurantByChefId(chefId);
    }
}