package it.beije.musicstore.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.musicstore.JPAEntityManagerFactory;
import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import it.beije.musicstore.service.AlbumService;
import it.beije.musicstore.service.ArtistaService;

@Controller
public class HelloController {
	
	@Autowired
	ArtistaService artistaService;
	@Autowired
	AlbumService albumService;
	
	public HelloController() {
		System.out.println("creo un oggetto HelloController...");
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request,Model model) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		
		int idArtista=1;

		List<Artista> artisti=artistaService.findByGenere("rock");
		List<Album> album=albumService.getAlbumByArtistaId(idArtista);
		System.out.println(artisti);
		
		model.addAttribute("album",album);
		model.addAttribute("artista",idArtista);
		model.addAttribute("artisti",artisti);
		
		return "index"; // /WEB-INF/views/index.jsp
	}
	
	
	
}
