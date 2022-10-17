package it.beije.musicstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.repository.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	AlbumRepository albumRepository;
	
	public List<Album> getAlbumByArtistaId(Integer id){
		return albumRepository.findByArtistaId(id);
	} 
	
	public List<Album> getAlbumByGenere(String genere){
		return albumRepository.findByGenere(genere);
	}
	
	public Optional<Album> getAlbumByCanzoneId(Integer album){
		return albumRepository.findById(album);
	}
}
