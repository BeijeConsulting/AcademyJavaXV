package it.beije.hopper.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.beije.hopper.model.User;
import it.beije.hopper.repository.UserRepository;


@Controller
public class UserController {

	@Autowired
	public UserRepository userRepository;
	
	public UserController() {
		System.out.println("creo un oggetto UserController");
	}
	
	@GetMapping(value = "/registrazione")
	public String registrazione() {
		System.out.println("POST registrazione");
		
		return "registrazione";
	}
	
	@PostMapping(value = "/user")
	public String insertUser(User user, Model model) {
		System.out.println("POST insertUser : " + user);
		
		userRepository.save(user);
		System.out.println("user post save : " + user);
		model.addAttribute("loggedUser", user);
		
		return "welcome";
	}
}
