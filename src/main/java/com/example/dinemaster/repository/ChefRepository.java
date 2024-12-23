package com.example.dinemaster.repository;

import java.util.ArrayList;

import com.example.dinemaster.model.Chef;

public interface ChefRepository {
    ArrayList<Chef> getAllChefs();

    Chef addChef(Chef chef);

    Chef getChefById(int id);

    Chef updateChef(int id, Chef chef);

    void deleteChef(int id);
}