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
		
		if(album != null && album.length() > 0) {
			Integer id_album = albumService.getIdByTitleAlbum(album);
			if(id_album > -1) {
				model.addAttribute("listSong" , songService.listSongByAlbum(id_album));
			}else {
				model.addAttribute("errore" , "ERRORE... Album non trovato");
			}
		}
		return "find_song_by_album"; 
	}
	
	@RequestMapping(value = {"/find_song_by_artist"}, method = RequestMethod.GET)
	public String index2(HttpServletRequest request, 
			Model model,
			@RequestParam(name = "artist", required = false) String artist) {

		if(artist != null && artist.length() > 0) {
			Integer id_artist = artistService.getIdByNameArtist(artist);
			if(id_artist > -1) {
				model.addAttribute("listSong" , songService.listSongByArtist(id_artist));
			}else {
				model.addAttribute("errore" , "ERRORE... Cantante non trovato");
			}
		}
		return "find_song_by_artist";
	}
}
