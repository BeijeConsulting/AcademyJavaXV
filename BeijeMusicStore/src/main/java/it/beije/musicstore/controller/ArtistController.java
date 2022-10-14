package it.beije.musicstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.musicstore.model.Artist;
import it.beije.musicstore.service.ArtistService;


@Controller
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;

	@RequestMapping(value = {"/find_artist_by_genre"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, 
			Model model,
			@RequestParam(name = "genre", required = false) String genre) {
		
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		model.addAttribute("listArtist" , artistService.listArtistByGenre(genre));

		return "find_artist_by_genre"; 
	}
	
}
