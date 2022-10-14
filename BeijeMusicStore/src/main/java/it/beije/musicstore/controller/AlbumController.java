package it.beije.musicstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.musicstore.model.Artist;
import it.beije.musicstore.service.AlbumService;
import it.beije.musicstore.service.ArtistService;


@Controller
public class AlbumController {

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private ArtistService artistService;

	@RequestMapping(value = {"/find_album_by_artist"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, 
			Model model,
			@RequestParam(name = "artist", required = false) String artist) {
		
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		
		//Integer id_artist = 1;  
		model.addAttribute("listArtist", artistService.listArtist());
		if(artist != null) {
			Integer id_artist = Integer.valueOf(artist);
			model.addAttribute("listAlbum" , albumService.listAlbumByArtist(id_artist));
		}
		

		return "find_album_by_artist"; 
	}
	
}
