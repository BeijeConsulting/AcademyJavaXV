package it.beije.musicstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.ArtistaService;
import it.beije.musicstore.service.CanzoneService;

@Controller
public class ArtistaController {
	
	@Autowired
	ArtistaService artistaService;
	@Autowired
	CanzoneService canzoneService;
	
	@RequestMapping(value ="artistbygenre", method = RequestMethod.GET)
	public String artistbygenre(HttpServletRequest request,Model model) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		List<Artista> artisti=artistaService.getByGenere("rap");
	
		model.addAttribute("artisti",artisti);
		return "artista";
	}
	
	@RequestMapping(value ="artistbysong", method = RequestMethod.GET)
	public String artistbysong(HttpServletRequest request,Model model) throws Exception {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		
		Canzone canzone=canzoneService.getCanzoniById(2);
		Artista artista=artistaService.getByIdArtista(canzone.getArtistaId());
		
		
		List<Artista> artistaLista=new ArrayList<>();
		artistaLista.add(artista);
		
		model.addAttribute("artisti",artistaLista);
		return "artista";
	}
}