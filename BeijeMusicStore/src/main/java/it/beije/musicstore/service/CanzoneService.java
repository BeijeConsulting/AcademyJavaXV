package it.beije.musicstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.repository.CanzoneRepository;

@Service
public class CanzoneService {

	@Autowired
	CanzoneRepository canzoneRepository;
	
	public List<Canzone> getCanzoniByAlbum(Integer album){
		return canzoneRepository.findByAlbumId(album);
	}
	
	public List<Canzone> getCanzoniByArtist(Integer artist){
		return canzoneRepository.findByArtistaId(artist);
	}
	
	public List<Canzone> getCanzoniByGenere(String genere){
		return canzoneRepository.findByGenere(genere);
	}
	
	public Optional<Canzone> getCanzoniById(Integer id){
		return canzoneRepository.findById(id);
	}
}
