package it.beije.musicstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.CanzoneService;


@Controller
public class CanzoneController {

	@Autowired
	CanzoneService canzoneService;
	
	@RequestMapping(value = "songbyalbum", method = RequestMethod.GET)
	public String songbyalbum(HttpServletRequest request,Model model) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		
		List<Canzone> canzoni=canzoneService.getCanzoniByAlbum(1);
		model.addAttribute("canzoni",canzoni);
		return "song";
	}
	
	@RequestMapping(value = "songbyartist", method = RequestMethod.GET)
	public String songbyartist(HttpServletRequest request,Model model) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		
		List<Canzone> canzoni=canzoneService.getCanzoniByArtist(1);
		model.addAttribute("canzoni",canzoni);
		return "song";
	}
	
	@RequestMapping(value = "songbygenre", method = RequestMethod.GET)
	public String songbygenre(HttpServletRequest request,Model model) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		
		List<Canzone> canzone=canzoneService.getCanzoniByGenere("rock");
		model.addAttribute("canzoni",canzone);
		return "song";
	}

}
