/*
package it.beije.magazzino.service;


import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.repository.ContenutoSpedizioneRepository;
import it.beije.magazzino.repository.ProdottoRepository;
import it.beije.magazzino.repository.SpedizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SpedizioneService {

	@Autowired
	private SpedizioneRepository spedizioneRepository;


	public SpedizioneService() {
		System.out.println("creo un oggetto SpedizioneService...");
	}

	public Optional<Spedizione> findById(Integer id) {
		return spedizioneRepository.findById(id);
	}

	public List<Spedizione> findAll() {return spedizioneRepository.findAll();}

	public void save(Spedizione p) {
		spedizioneRepository.save(p);
	}

	public void delete(Spedizione p) {
		spedizioneRepository.delete(p);
	}



}
*/
