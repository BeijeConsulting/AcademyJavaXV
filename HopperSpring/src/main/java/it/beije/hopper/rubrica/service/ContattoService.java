package it.beije.hopper.rubrica.service;


import it.beije.hopper.rubrica.model.Contatto;
import it.beije.hopper.rubrica.repository.ContattoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ContattoService {

	@Autowired
	private ContattoRepository contattoRepository;


	public ContattoService() {
		System.out.println("creo un oggetto OrderService...");
	}
	
	public Optional<Contatto> findById(Integer userId) {
		return contattoRepository.findById(userId);
	}

	public void save(Contatto contatto) {
		contattoRepository.save(contatto);
	}

	public void delete(Contatto contatto) {
		contattoRepository.delete(contatto);
	}
}
