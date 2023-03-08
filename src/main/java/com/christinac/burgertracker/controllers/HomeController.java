package com.christinac.burgertracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	public String createBurger(@Valid @ModelAttribute("newBurger") Burger newBurger, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Burger> allBurgers = burgerServ.findAll();
			model.addAttribute("allBurgers", allBurgers);
			return "index.jsp";
		}
		burgerServ.create(newBurger);
		return "redirect:/";
	}
	
	@GetMapping("/burgers/{id}/edit")
	public String editBurger(@PathVariable("id") Long id, Model model) {
		Burger thisBurger = burgerServ.findById(id);
		model.addAttribute("thisBurger", thisBurger);
		return "editBurger.jsp";
	}
	
	@PutMapping("burgers/{id}/edit")
	public String updateBurger(@Valid @ModelAttribute("thisBurger") Burger thisBurger, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "editBurger.jsp";
		} else {
			thisBurger.setId(id);
			burgerServ.update(thisBurger);
			return "redirect:/";
		}
	}
}
