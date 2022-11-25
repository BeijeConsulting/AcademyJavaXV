/*
package it.beije.magazzino.service;


import it.beije.magazzino.model.ContenutoSpedizione;
import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.repository.ContenutoSpedizioneRepository;
import it.beije.magazzino.repository.SpedizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContenutoSpedizioneService {

	@Autowired
	private ContenutoSpedizioneRepository contenutoSpedizioneRepository;


	public ContenutoSpedizioneService() {
		System.out.println("creo un oggetto contenutoSpedizioneService...");
	}

	public Optional<ContenutoSpedizione> findById(Integer id) {
		return contenutoSpedizioneRepository.findById(id);
	}

	public Optional<ContenutoSpedizione> findBySpedizione_Id(Integer id) {
		return contenutoSpedizioneRepository.findBySpedizione_id(id);
	}

	public List<ContenutoSpedizione> findAll() {return contenutoSpedizioneRepository.findAll();}

	public void save(ContenutoSpedizione c) {
		contenutoSpedizioneRepository.save(c);
	}

	public void delete(ContenutoSpedizione c) {
		contenutoSpedizioneRepository.delete(c);
	}



}
*/
