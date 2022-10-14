package it.beije.musicstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.repository.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	AlbumRepository albumRepository;
	
	public List<Album> getAlbumByArtistaId(Integer id){
		List<Album> album=albumRepository.findByArtistaId(id);
		return album;
	}
	
	public List<Album> getAlbumByGenere(String genere){
		List<Album> album=albumRepository.findByGenere(genere);
		return album;
	}
}
