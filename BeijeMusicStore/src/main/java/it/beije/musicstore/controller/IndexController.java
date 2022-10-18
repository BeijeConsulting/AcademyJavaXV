package it.beije.musicstore.controller;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.AlbumService;
import it.beije.musicstore.service.ArtistaService;
import it.beije.musicstore.service.CanzoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class IndexController {
	@Autowired
	private ArtistaService artistaService;
	@Autowired
	private CanzoneService canzoneService;
	@Autowired
	private AlbumService albumService;


	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {

		return "home"; // /WEB-INF/views/search.jsp
	}
	@RequestMapping(value = {"/search"}, method = RequestMethod.GET)
	public String search(HttpServletRequest request, Model model) {
		List<String> generiArtisti = artistaService.getAllGeneri();
		model.addAttribute("generiArtisti", generiArtisti);

		List<String> generiCanzoni = canzoneService.getAllGeneri();
		model.addAttribute("generiCanzoni", generiCanzoni);

		List<String> generiAlbum = albumService.getAllGeneri();
		model.addAttribute("generiAlbum", generiCanzoni);

		List<Artista> artisti = artistaService.getAll();
		model.addAttribute("artisti", artisti);

		List<Album> albums = albumService.getAll();
		model.addAttribute("albums", albums);

		List<Canzone> canzoni = canzoneService.getAll();
		model.addAttribute("canzoni", canzoni);

		return "search"; // /WEB-INF/views/search.jsp
	}

	@RequestMapping(value = {"/search_canzone"}, method = RequestMethod.GET)
	public String searchCanzone(HttpServletRequest request, Model model) {
		List<String> generiArtisti = artistaService.getAllGeneri();
		model.addAttribute("generiArtisti", generiArtisti);

		List<String> generiCanzoni = canzoneService.getAllGeneri();
		model.addAttribute("generiCanzoni", generiCanzoni);

		List<String> generiAlbum = albumService.getAllGeneri();
		model.addAttribute("generiAlbum", generiCanzoni);

		List<Artista> artisti = artistaService.getAll();
		model.addAttribute("artisti", artisti);

		List<Album> albums = albumService.getAll();
		model.addAttribute("albums", albums);

		List<Canzone> canzoni = canzoneService.getAll();
		model.addAttribute("canzoni", canzoni);

		return "search_canzone"; // /WEB-INF/views/search.jsp
	}

	@RequestMapping(value = {"/search_artista"}, method = RequestMethod.GET)
	public String searchArtista(HttpServletRequest request, Model model) {
		List<String> generiArtisti = artistaService.getAllGeneri();
		model.addAttribute("generiArtisti", generiArtisti);

		List<String> generiCanzoni = canzoneService.getAllGeneri();
		model.addAttribute("generiCanzoni", generiCanzoni);

		List<String> generiAlbum = albumService.getAllGeneri();
		model.addAttribute("generiAlbum", generiCanzoni);

		List<Artista> artisti = artistaService.getAll();
		model.addAttribute("artisti", artisti);

		List<Album> albums = albumService.getAll();
		model.addAttribute("albums", albums);

		List<Canzone> canzoni = canzoneService.getAll();
		model.addAttribute("canzoni", canzoni);

		return "search_artista"; // /WEB-INF/views/search.jsp
	}

	@RequestMapping(value = {"/search_album"}, method = RequestMethod.GET)
	public String searchAlbum(HttpServletRequest request, Model model) {
		List<String> generiArtisti = artistaService.getAllGeneri();
		model.addAttribute("generiArtisti", generiArtisti);

		List<String> generiCanzoni = canzoneService.getAllGeneri();
		model.addAttribute("generiCanzoni", generiCanzoni);

		List<String> generiAlbum = albumService.getAllGeneri();
		model.addAttribute("generiAlbum", generiCanzoni);

		List<Artista> artisti = artistaService.getAll();
		model.addAttribute("artisti", artisti);

		List<Album> albums = albumService.getAll();
		model.addAttribute("albums", albums);

		List<Canzone> canzoni = canzoneService.getAll();
		model.addAttribute("canzoni", canzoni);

		return "search_album"; // /WEB-INF/views/search.jsp
	}

}
