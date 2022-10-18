package it.beije.musicstore.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.musicstore.service.AlbumService;
import it.beije.musicstore.service.ArtistService;
import it.beije.musicstore.model.Album;



@RestController
@RequestMapping(value = "api")
public class AlbumRestController {

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private ArtistService artistService;

	@GetMapping(value = "/find_album_by_artist/{artist}")
	public List<Album> index(@PathVariable(name = "artist") String artist) {
		
		if(artist != null && artist.length() > 0) {
			Integer id_artist = artistService.getIdByNameArtist(artist);
			if(id_artist > -1)
			return albumService.listAlbumByArtist(id_artist);
		}
		return null; 
	}
	
	@GetMapping(value = "/find_album_by_genre/{genre}")
	public List<Album> index2(@PathVariable(name = "genre") String genre) {
		
		List<Album> albums = null;
		if(genre != null && genre.length() > 0) {
			albums = albumService.getAlbumsByGenre(genre);
			if(albums == null || albums.size() < 0)
			return null;
		}
		return albums; 
	}
	
	
	@GetMapping(value = "/find_album_by_song/{song}")
	public Album index3(@PathVariable(name = "song") String song) {
		
		Album album = null;
		if(song != null && song.length() > 0) 
			album = albumService.getAlbumByTitleSong(song);
		
		return album; 
	}
}
