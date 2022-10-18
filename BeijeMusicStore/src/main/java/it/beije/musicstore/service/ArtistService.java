package it.beije.musicstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.musicstore.model.Artist;
import it.beije.musicstore.model.Song;
import it.beije.musicstore.repository.ArtistRepository;
import it.beije.musicstore.repository.SongRepository;



@Service
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;
	
	@Autowired
	private SongRepository songRepository;
	
	public List<Artist> listArtistByGenre(String genre){
		//genre = genre.toLowerCase();
		return artistRepository.loadByGenre(genre);
	}
	
	public List<Artist>listAllArtist(){
		return artistRepository.loadAllArtist();
	}
	
	public Artist getArtisyByName(String name) {
		return artistRepository.loadByName(name);
	}
	
	public int getIdByNameArtist(String name) {
		Artist artist = artistRepository.loadByName(name);
		if(artist == null) return -1;
		return artist.getId();
	}
	
	public Artist getArtistBySong(String title) {
		Song song = songRepository.findByTitle(title);
		if(song == null) return null;
		return artistRepository.loadById(song.getId_artist());
	}
	
}
