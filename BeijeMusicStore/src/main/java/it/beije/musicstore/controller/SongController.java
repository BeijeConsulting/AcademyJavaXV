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

import it.beije.musicstore.service.AlbumService;
import it.beije.musicstore.service.ArtistService;
import it.beije.musicstore.service.SongService;

@Controller
public class SongController {

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private ArtistService artistService;
	
	
	@Autowired
	private SongService songService;

	@RequestMapping(value = {"/find_song_by_album"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, 
			Model model,
			@RequestParam(name = "album", required = false) String album) {
		
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		
		//Integer id_artist = 1;  
		//model.addAttribute("listArtist", artistService.listArtist());
		model.addAttribute("listAlbum", albumService.listAllAlbum());
		if(album != null) {
			Integer id_album = Integer.valueOf(album);
			model.addAttribute("listSong" , songService.listSongByAlbum(id_album));
		}
		

		return "find_song_by_album"; 
	}
	
	
	
	@RequestMapping(value = {"/find_song_by_artist"}, method = RequestMethod.GET)
	public String index2(HttpServletRequest request, 
			Model model,
			@RequestParam(name = "artist", required = false) String artist) {
		
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		
		//Integer id_artist = 1;  
		//model.addAttribute("listArtist", artistService.listArtist());
		model.addAttribute("listArtist", artistService.listAllArtist());
		if(artist != null) {
			Integer id_artist = Integer.valueOf(artist);
			model.addAttribute("listSong" , songService.listSongByArtist(id_artist));
		}
		

		return "find_song_by_artist"; 
	}
	
}
