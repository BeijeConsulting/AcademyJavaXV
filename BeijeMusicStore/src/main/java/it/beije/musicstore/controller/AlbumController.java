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
		
		model.addAttribute("listArtist", artistService.listAllArtist());
		if(artist != null && artist.length() > 0) {
			Integer id_artist = null;
			try {
			 id_artist = Integer.valueOf(artist);
			 model.addAttribute("listAlbum" , albumService.listAlbumByArtist(id_artist));
			}catch(NumberFormatException numb) {
				model.addAttribute("errore", "INSERISCI UN VALORE CORRETTO");
			}	
		}else { //KO
			model.addAttribute("errore", "INSERISCI UN VALORE");
		}
		return "find_album_by_artist"; 
	}
	
}
