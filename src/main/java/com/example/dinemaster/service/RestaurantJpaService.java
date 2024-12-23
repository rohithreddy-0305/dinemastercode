package com.example.dinemaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.repository.RestaurantJpaRepository;
import com.example.dinemaster.repository.RestaurantRepository;

@Service
public class RestaurantJpaService implements RestaurantRepository {

	@Autowired
	private RestaurantJpaRepository restaurantRepository;

	@Override
	public ArrayList<Restaurant> getAllRestaurants() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		ArrayList<Restaurant> restaurantsList = new ArrayList<>(restaurants);
		return restaurantsList;
	}

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant getRestaurantById(int id) {
		try {
			Restaurant existingRestaurant = restaurantRepository.findById(id).get();
			return existingRestaurant;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Restaurant updateRestaurant(int id, Restaurant restaurant) {
		try {
			Restaurant existingRestaurant = restaurantRepository.findById(id).get();
			if (restaurant.getName() != null) {
				existingRestaurant.setName(restaurant.getName());
			}
			if (restaurant.getAddress() != null) {
				existingRestaurant.setAddress(restaurant.getAddress());
			}
			if (restaurant.getCuisineType() != null) {
				existingRestaurant.setCuisineType(restaurant.getCuisineType());
			}
			if (restaurant.getRating() != 0) {
				existingRestaurant.setRating(restaurant.getRating());
			}
			return restaurantRepository.save(existingRestaurant);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteRestaurant(int id) {
		if (restaurantRepository.existsById(id)) {
			restaurantRepository.deleteById(id);
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

}
