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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


@Controller
public class IndexController {
	@Autowired
	private ArtistaService artistaService;
	@Autowired
	private CanzoneService canzoneService;
	@Autowired
	private AlbumService albumService;



	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
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

		return "welcome"; // /WEB-INF/views/welcome.jsp
	}

}
