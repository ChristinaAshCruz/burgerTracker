package com.christinac.burgertracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.christinac.burgertracker.models.Burger;
import com.christinac.burgertracker.services.BurgerService;

@Controller
public class HomeController {
	
	@Autowired
	private BurgerService burgerServ;
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("newBurger") Burger newBurger) {
		List<Burger> allBurgers = burgerServ.findAll();
		model.addAttribute("allBurgers", allBurgers);
		return "index.jsp";
	}
	
	@PostMapping("/burger/new")
	public String createBurger(@Valid @ModelAttribute("newBurger") Burger newBurger, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		burgerServ.create(newBurger);
		return "redirect:/";
	}
}
