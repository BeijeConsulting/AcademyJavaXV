package it.beije.musicstore.service;


import it.beije.musicstore.model.Artista;
import it.beije.musicstore.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ArtistaService {

	@Autowired
	private ArtistaRepository artistaRepository;


	public ArtistaService() {
		System.out.println("creo un oggetto artistaService...");
	}
	
	public List<Artista> findByGenere(String genere) {
		return artistaRepository.findByGenere(genere);
	}

	public List<Artista> getAll() {
		return artistaRepository.findAll();
	}

	public List<String> getAllGeneri() {
		return artistaRepository.getallGeneri();
	}

	public Optional<Artista> findById(Integer id) {
		return artistaRepository.findById(id);
	}

}
