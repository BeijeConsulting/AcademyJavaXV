package it.beije.musicstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.musicstore.model.Artista;
import it.beije.musicstore.repository.ArtistaRepository;
import it.beije.musicstore.repository.CanzoneRepository;

@Service
public class ArtistaService {
	
	@Autowired
	private ArtistaRepository artistaRepository;
	
	public Artista findByNome(String nome) {
		return artistaRepository.findByNome(nome);
	}

}
