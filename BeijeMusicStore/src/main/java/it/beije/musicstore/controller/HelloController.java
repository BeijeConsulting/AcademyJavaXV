package it.beije.musicstore.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.musicstore.JPAEntityManagerFactory;
import it.beije.musicstore.model.Artista;

@Controller
public class HelloController {
	
	
	public HelloController() {
		System.out.println("creo un oggetto HelloController...");
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request,Model model) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		
		EntityManager entityManager=JPAEntityManagerFactory.openSession();
		
		Query query=entityManager.createQuery("SELECT a FROM Artista as a WHERE a.genere='rock'");
		List<Artista> artisti=query.getResultList();
		
		System.out.println(artisti);
		model.addAttribute("artisti",artisti);
		
		return "index"; // /WEB-INF/views/index.jsp
	}
	
}
