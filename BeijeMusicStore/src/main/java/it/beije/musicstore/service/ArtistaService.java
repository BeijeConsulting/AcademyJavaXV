package it.beije.musicstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.musicstore.model.Artista;
import it.beije.musicstore.repository.ArtistaRepository;

@Service
public class ArtistaService {

	@Autowired
	ArtistaRepository artistaRepository;
	
	public List<Artista> findByGenere(String genere){
		List<Artista> artisti=artistaRepository.findByGenere(genere);
		
		return artisti;
	}
	
}
