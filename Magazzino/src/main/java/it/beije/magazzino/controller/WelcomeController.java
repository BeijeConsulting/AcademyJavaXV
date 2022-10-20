package it.beije.magazzino.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	
	public WelcomeController() {
		System.out.println("creo un oggetto Benvenuto...");
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Welcome(HttpServletRequest request,Model model) {
		System.out.println("Welcome Page Requested : " + request.getRequestURI());
		
		return "Welcome";
	}
	
	

	
	
	
	
	
}