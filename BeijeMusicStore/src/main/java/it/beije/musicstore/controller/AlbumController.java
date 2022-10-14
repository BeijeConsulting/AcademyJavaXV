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

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.AlbumService;
import it.beije.musicstore.service.CanzoneService;

@Controller
public class AlbumController {

	@Autowired
	AlbumService albumService;
	@Autowired
	CanzoneService canzoneService;
	
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
		
		List<Album> album=albumService.getAlbumByGenere("rap");
		model.addAttribute("album",album);
		return "album";
	}
	
	@RequestMapping(value = "albumbysong", method = RequestMethod.GET)
	public String albumbysong(HttpServletRequest request,Model model) throws Exception {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		
		Optional<Canzone> canzone=canzoneService.getCanzoniById(2);
		
		if(!canzone.isPresent())
			throw new Exception("Canzone non trovata");
		
		Optional<Album> album=albumService.getAlbumByCanzoneId(canzone.get().getAlbumId());
		
		if(!album.isPresent())
			throw new Exception("Album non trovato");
		List<Album> albumList=new ArrayList<>();
		albumList.add(album.get());
		model.addAttribute("album",albumList);
		return "album";
	}
	
	
	
	
}
