package it.beije.musicstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.CanzoneService;


@RestController
@RequestMapping(value = "song")
public class CanzoneRestController {

	@Autowired
	CanzoneService canzoneService;
	
	@GetMapping(value = "/songbyalbum")
	public List<Canzone> songbyalbum(Model model) {
		
		List<Canzone> canzoni=canzoneService.getCanzoniByAlbum(1);
		model.addAttribute("canzoni",canzoni);
		return canzoni;
	}
	
	@GetMapping(value = "/songbyartist")
	public List<Canzone> songbyartist(Model model) {	
		
		List<Canzone> canzoni=canzoneService.getCanzoniByArtist(2);
		model.addAttribute("canzoni",canzoni);
		return canzoni;
	}
	
	@GetMapping(value = "/songbygenre")
	public List<Canzone> songbygenre(Model model) {
		
		List<Canzone> canzoni=canzoneService.getCanzoniByGenere("rock");
		model.addAttribute("canzoni",canzoni);
		return canzoni;
	}

}
