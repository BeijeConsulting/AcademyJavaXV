package it.beije.magazzino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.beije.magazzino.model.Product;
import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.repository.ProductRepository;
import it.beije.magazzino.repository.SpedizioneRepository;


@Service
public class SpedizioneService {
	
	@Autowired
	private SpedizioneRepository spedizioneRepository;

	public SpedizioneService() {
		System.out.println("creo un oggetto ProductService...");
	}

	public List<Spedizione> findAll() {
		
		return spedizioneRepository.findAll();
	}

	


}