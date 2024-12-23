package com.example.dinemaster.service;

import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.repository.ChefJpaRepository;
import com.example.dinemaster.repository.ChefRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChefJpaService implements ChefRepository {

	@Autowired
	private ChefJpaRepository chefRepository;

	@Override
	public ArrayList<Chef> getAllChefs() {
		List<Chef> chefsList = chefRepository.findAll();
		ArrayList<Chef> chefs = new ArrayList<>(chefsList);
		return chefs;
	}

	@Override
	public Chef addChef(Chef chef) {
		return chefRepository.save(chef);
	}

	@Override
	public Chef getChefById(int id) {
		try {
			Chef existingChef = chefRepository.findById(id).get();
			return existingChef;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Chef updateChef(int id, Chef chef) {
		try {
			Chef existingChef = chefRepository.findById(id).get();

			if (chef.getFirstName() != null) {
				existingChef.setFirstName(chef.getFirstName());
			}
			if (chef.getLastName() != null) {
				existingChef.setLastName(chef.getLastName());
			}
			if (chef.getExpertise() != null) {
				existingChef.setExpertise(chef.getExpertise());
			}
			if (chef.getExperienceYears() != 0) {
				existingChef.setExperienceYears(chef.getExperienceYears());
			}
			if (chef.getRestaurant() != null) {
				existingChef.setRestaurant(chef.getRestaurant());
			}
			return chefRepository.save(existingChef);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteChef(int id) {
		if (chefRepository.existsById(id)) {
			chefRepository.deleteById(id);
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	public Restaurant getRestaurantByChefId(int chefId) {
		try {
			Chef chef = chefRepository.findById(chefId).get();
			return chef.getRestaurant();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}