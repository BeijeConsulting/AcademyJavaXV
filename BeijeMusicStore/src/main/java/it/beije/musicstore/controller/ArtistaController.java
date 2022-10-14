package it.beije.musicstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.musicstore.model.Artista;
import it.beije.musicstore.service.ArtistaService;

@Controller
public class ArtistaController {
	
	@Autowired
	ArtistaService artistaService;
	
	@RequestMapping(value ="artistByGenre", method = RequestMethod.GET)
	public String artistbygenre(HttpServletRequest request,Model model) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		List<Artista> artisti=artistaService.findByGenere("rock");
	
		model.addAttribute("artisti",artisti);
		return "artist_by_genre";
	}
}
