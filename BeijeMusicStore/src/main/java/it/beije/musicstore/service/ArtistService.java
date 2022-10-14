package it.beije.musicstore.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.musicstore.model.Artist;
import it.beije.musicstore.repository.ArtistRepository;



@Service
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;
	
	public List<Artist> listArtistByGenre(String genre){
		genre = genre.toLowerCase();
		return artistRepository.loadByGenre(genre);
	}
	
	public List<Artist>listAllArtist(){
		return artistRepository.loadAllArtist();
	}
	
	
	
}
