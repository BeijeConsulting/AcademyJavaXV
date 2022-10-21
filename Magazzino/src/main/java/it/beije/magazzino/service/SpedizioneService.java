package it.beije.magazzino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.repository.ProdottoRepository;
import it.beije.magazzino.repository.SpedizioneRepository;

@Service
public class SpedizioneService {
	
	@Autowired
	private SpedizioneRepository spedizioneRepository;

	public List<Spedizione> findAll() {
		return spedizioneRepository.findAll();
	}

}
