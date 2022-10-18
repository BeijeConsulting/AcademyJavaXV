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
	
	public Album getAlbumByCanzoneId(Integer canzoneId){
		return albumRepository.findById(canzoneId).get();
	}

	public void checkAlbum(Album album) {
		if(album.getArtistaId()==null) {
			throw new IllegalArgumentException("Il campo 'id_artista' non può essere null");
		}
		
		if(album.getGenere()==null) {
			throw new IllegalArgumentException("Il campo 'genere' non può essere null");
		}
		
		if(album.getDataDiUscita()==null) {
			throw new IllegalArgumentException("Il campo 'data_di_uscita' non può essere null");
		}
		
		if(album.getTitolo()==null) {
			throw new IllegalArgumentException("Il campo 'titolo' non può essere null");
		}
		
	}
}
