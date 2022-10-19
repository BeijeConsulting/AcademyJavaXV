package it.beije.musicstore.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Artist> findArtistByGenre(@PathVariable(name = "genre") String genre) {
		
		if(genre != null && genre.length() > 0) {
			List<Artist> listArtist = artistService.listArtistByGenre(genre);
			if(listArtist != null && listArtist.size() > 0)
				return listArtist;		
		}
		return null;
	}
	
	@GetMapping(value = "/find_artist_by_song/{song}")
	public Artist findArtistBySong(@PathVariable(name = "song") String song) {
		
		if(song != null && song.length() > 0) {
			return artistService.getArtistBySong(song);
		}
		return null;
	}
	
	@PostMapping(value = "/add_artist")
	public boolean findArtistBySong(@RequestBody Artist artist) {
		return artistService.addArtist(artist);
	}
	
	@DeleteMapping(value = "/delateArtist/{name}")
	public boolean deleteUser(@PathVariable(name = "name") String name) {
		artistService.deleteArtist(name);		
		return true;
	}
}
