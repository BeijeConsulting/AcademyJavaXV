package it.beije.musicstore.controller;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	
	public HelloController() {
		System.out.println("creo un oggetto HelloController...");
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());

		EntityManager entityManager;
		
		return "index"; // /WEB-INF/views/index.jsp
	}
	
}
