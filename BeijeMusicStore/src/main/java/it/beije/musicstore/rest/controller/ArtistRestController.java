package it.beije.musicstore.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.musicstore.service.ArtistService;
import it.beije.musicstore.model.Artist;


@RestController
@RequestMapping(value = "api")
public class ArtistRestController {

	@Autowired
	private ArtistService artistService;

	@GetMapping(value = "/find_artist_by_genre/{genre}")
	public List<Artist> index(@PathVariable(name = "genre") String genre) {
		
		if(genre != null && genre.length() > 0) {
			List<Artist> listArtist = artistService.listArtistByGenre(genre);
			if(listArtist != null && listArtist.size() > 0)
				return listArtist;		
		}
		return null;
	}
	
	@GetMapping(value = "/find_artist_by_song/{song}")
	public Artist index2(@PathVariable(name = "song") String song) {
		
		if(song != null && song.length() > 0) {
			return artistService.getArtistBySong(song);
		}
		
		return null;
	}
	
}
