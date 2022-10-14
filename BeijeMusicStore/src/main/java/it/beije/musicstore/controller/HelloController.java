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
		
		return "index"; // /WEB-INF/views/index.jsp
	}
	
	@RequestMapping(value = "artistbygenre", method = RequestMethod.GET)
	public String artistbygenre(HttpServletRequest request,Model model) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		
		List<Artista> artisti=artistaService.findByGenere("rock");
		model.addAttribute("artisti",artisti);
		
		return "artist_by_genre"; // /WEB-INF/views/index.jsp
	}
	
	@RequestMapping(value = "albumbyartist", method = RequestMethod.GET)
	public String albumbyartist(HttpServletRequest request,Model model) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		
		int idArtista=1;
		List<Album> album=albumService.getAlbumByArtistaId(idArtista);
		
		model.addAttribute("album",album);
		model.addAttribute("artista",idArtista);
		
		return "album_by_artist"; // /WEB-INF/views/index.jsp
	}
	
	
	
	
	
	
	
}
