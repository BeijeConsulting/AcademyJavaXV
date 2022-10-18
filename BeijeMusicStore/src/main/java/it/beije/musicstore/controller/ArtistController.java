package it.beije.musicstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
		
		if(genre != null && genre.length() > 0) {
			List<Artist> listArtist = artistService.listArtistByGenre(genre);
			if(listArtist != null && listArtist.size() > 0)
				model.addAttribute("listArtist" , listArtist);
			else
				model.addAttribute("errore", "INSERISCI UN VALORE CORRETTO");
		}else {
			model.addAttribute("errore", "INSERISCI UN VALORE");
		}
		

		return "find_artist_by_genre"; 
	}
	
	
	
}
