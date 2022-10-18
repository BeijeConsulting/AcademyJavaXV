package it.beije.musicstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		if(artist != null && artist.length() > 0) {
			Integer id_artist = artistService.getIdByNameArtist(artist);
			if(id_artist > -1) {
			 model.addAttribute("listAlbum" , albumService.listAlbumByArtist(id_artist));
			}else{
				model.addAttribute("errore", "INSERISCI UN VALORE CORRETTO");
			}	
		}else { //KO
			model.addAttribute("errore", "INSERISCI UN VALORE");
		}
		return "find_album_by_artist"; 
	}
	
}
