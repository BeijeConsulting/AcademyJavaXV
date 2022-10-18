package it.beije.musicstore.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.musicstore.service.AlbumService;
import it.beije.musicstore.service.ArtistService;
import it.beije.musicstore.service.SongService;
import it.beije.musicstore.model.Song;

@RestController
@RequestMapping(value = "api")
public class SongRestController {

	@Autowired
	private AlbumService albumService;

	@Autowired
	private ArtistService artistService;


	@Autowired
	private SongService songService;
	
	@GetMapping(value = "/find_song_by_album/{album}")
	public List<Song> index(@PathVariable(name = "album") String album) {
		
		if(album != null && album.length() > 0) {
			Integer id_album = albumService.getIdByTitleAlbum(album);
			if(id_album > -1) 
				return songService.listSongByAlbum(id_album);
		}
		return null;
	}
	
	
	@GetMapping(value = "/find_song_by_artist/{artist}")
	public List<Song> index2(@PathVariable(name = "artist") String artist){

		if(artist != null && artist.length() > 0) {
			Integer id_artist = artistService.getIdByNameArtist(artist);
			if(id_artist > -1) 
				return songService.listSongByArtist(id_artist);	
		}
		return null;
	}
	
	
	@GetMapping(value = "/find_song_by_genre/{genre}")
	public List<Song> index3(@PathVariable(name = "genre") String genre){

		if(genre != null && genre.length() > 0) {
			List<Song> songs = songService.listSongByGenre(genre);
			if( songs != null) 
				return songs;	
		}
		return null;
	}
	
}
