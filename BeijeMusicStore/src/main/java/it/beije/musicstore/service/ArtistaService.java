package it.beije.musicstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.musicstore.model.Artista;
import it.beije.musicstore.repository.ArtistaRepository;

@Service
public class ArtistaService {

	@Autowired
	ArtistaRepository artistaRepository;
	
	public List<Artista> getByGenere(String genere){		
		return artistaRepository.findByGenere(genere);
	}

	public Optional<Artista> getByIdArtista(Integer id){
		return artistaRepository.findById(id);
	}
}
