package it.beije.musicstore.controller;

import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.ArtistaService;
import it.beije.musicstore.service.CanzoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class CanzoneController {

	@Autowired
	private CanzoneService canzoneService;

	public CanzoneController() {
		System.out.println("creo un oggetto MusicController...");
	}
	

	@RequestMapping(value = "/canzoni_by_album", method = RequestMethod.GET)
	public String canzoniByAlbum(HttpSession session,
					   @RequestParam(name = "id_album", required = true) Integer id, Model model) {
		System.out.println("id_album : " + id);

		List<Canzone> lista = canzoneService.findByAlbum(id);
		System.out.println("lista : " + lista);
		model.addAttribute("lista", lista);

		//TODO
		return "TODO";
	}

	@RequestMapping(value = "/canzoni_by_artista", method = RequestMethod.GET)
	public String canzoniByArtista(HttpSession session,
								  @RequestParam(name = "id_artista", required = true) Integer id, Model model) {
		System.out.println("id_artista : " + id);

		List<Canzone> lista = canzoneService.findByArtista(id);
		System.out.println("lista : " + lista);
		model.addAttribute("lista", lista);

		//TODO
		return "TODO";
	}

	@RequestMapping(value = "/canzone_by_genere", method = RequestMethod.GET)
	public String canzoneByGenere(HttpSession session,
								  @RequestParam(name = "genere", required = true) String genere, Model model) {
		System.out.println("test : " + genere);

		List<Artista> lista =  canzoneService.findByGenere(genere);
		System.out.println("lista : " + lista);
		model.addAttribute("lista", lista);

		//TODO
		return "TODO";
	}

}
