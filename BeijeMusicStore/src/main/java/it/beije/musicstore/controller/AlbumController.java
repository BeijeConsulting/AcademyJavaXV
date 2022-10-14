package it.beije.musicstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.service.AlbumService;

@Controller
public class AlbumController {

	@Autowired
	AlbumService albumService;
	
	@RequestMapping(value ="albumbyartist", method = RequestMethod.GET)
	public String albumbyartist(HttpServletRequest request,Model model) {
		int idArtista=1;

		List<Album> album=albumService.getAlbumByArtistaId(idArtista);
		
		model.addAttribute("album",album);
		model.addAttribute("artista",idArtista);
		return "album";
	}
	
	
	@RequestMapping(value = "albumbygenre", method = RequestMethod.GET)
	public String albumbygenre(HttpServletRequest request,Model model) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		
		List<Album> album=albumService.getAlbumByGenere("rock");
		model.addAttribute("album",album);
		return "album";
	}
}
