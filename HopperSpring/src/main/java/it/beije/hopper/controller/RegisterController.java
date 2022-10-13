package it.beije.hopper.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.hopper.model.User;
import it.beije.hopper.repository.UserRepository;
import it.beije.hopper.service.UserService;

@Controller
public class RegisterController {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/register", "registrazione"}, method = RequestMethod.GET)
	public String registerGet(HttpServletRequest request) {
		

		return "register"; // /WEB-INF/views/beije.jsp
	}
	
	@RequestMapping(value = {"/register", "registrazione"}, method = RequestMethod.POST)
	public String registerPost(
			HttpServletRequest request, 
			Model model,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "surname", required = false) String surname,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "password", required = false) String password){

		try {
			User user = userService.registerUser(email, password, name, surname);
			model.addAttribute("loggedUser" , user);
			userRepository.save(user);
		}catch(Exception presente) {
			model.addAttribute("errore", "Attenzione, utente già registrato");
			return "register";
		}
		
		return "welcome";
	}
	
}