package com.christinac.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christinac.burgertracker.models.Burger;
import com.christinac.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	@Autowired
	private BurgerRepository burgerRepo;
	
	public List<Burger> findAll(){
		return burgerRepo.findAll();
	}
	
	public Burger create(Burger b) {
		return burgerRepo.save(b);
	}
	
	public Burger findById(Long id) {
		Optional<Burger> optionalBurger = burgerRepo.findById(id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
		} else {
			return null;
		}	
	}
	
	public Burger update(Burger b) {
		return burgerRepo.save(b);
	}
}
