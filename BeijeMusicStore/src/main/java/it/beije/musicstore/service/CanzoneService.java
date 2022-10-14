package it.beije.musicstore.service;


import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.repository.ArtistaRepository;
import it.beije.musicstore.repository.CanzoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CanzoneService {

	@Autowired
	private CanzoneRepository canzoneRepository;


	public CanzoneService() {
		System.out.println("creo un oggetto canzoneService...");
	}

	public List<Canzone> findByAlbum(Integer id_album) {
		return canzoneRepository.findByAlbum(id_album);
	}

	public List<Canzone> findByArtista(Integer id_artista) {
		return (List<Canzone>) canzoneRepository.findByArtista(id_artista);
	}

	public List<Canzone> findByGenere(String genere) {
		return canzoneRepository.findByGenere(genere);
	}

	public List<String> getAllGeneri() {
		return canzoneRepository.getallGeneri();
	}

	public List<Canzone> getAll() {
		return canzoneRepository.findAll();
	}

}
