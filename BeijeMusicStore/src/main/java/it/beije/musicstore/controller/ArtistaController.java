package it.beije.musicstore.controller;

import it.beije.musicstore.model.Artista;
import it.beije.musicstore.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


@Controller
public class ArtistaController {
	
	@Autowired
	private ArtistaService artistaService;

	public ArtistaController() {
		System.out.println("creo un oggetto MusicController...");
	}
	

	@RequestMapping(value = "/artista_by_genere", method = RequestMethod.GET)
	public String artistaByGenere(HttpSession session,
					   @RequestParam(name = "genere", required = true) String genere, Model model) {
		System.out.println("test : " + genere);

		List<Artista> lista = artistaService.findByGenere(genere);
		System.out.println("lista : " + lista);
		model.addAttribute("lista", lista);

		//TODO
		return "TODO";
	}

	@RequestMapping(value = "/artista_by_id", method = RequestMethod.GET)
	public String artistaById(HttpSession session,
								  @RequestParam(name = "id", required = true) Integer id, Model model) {
		System.out.println("test : " + id);

		Optional<Artista> art = artistaService.findById(id);
		System.out.println("artista : " + art);
		model.addAttribute("artista", art);

		//TODO
		return "TODO";
	}

}
