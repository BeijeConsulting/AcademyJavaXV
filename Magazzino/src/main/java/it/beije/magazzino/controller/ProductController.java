package it.beije.magazzino.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProductController {

//	@RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
//	public String registerGet(HttpServletRequest request) {
//		return "home"; // /WEB-INF/views/beije.jsp
//	}
	
	@GetMapping(value = "/home")
	public String home() {
		System.out.println("POST registrazione");
		
		return "home";
	}
	
}
