package it.beije.magazzino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.magazzino.model.ContenutoProdotto;
import it.beije.magazzino.model.Product;
import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.repository.ContenutoRepository;
import it.beije.magazzino.repository.ProductRepository;
import it.beije.magazzino.repository.SpedizioneRepository;


@Service
public class ContenutoService {
	
	@Autowired
	private ContenutoRepository contenutoRepository;

	public ContenutoService() {
		System.out.println("creo un oggetto ProductService...");
	}

	public List<ContenutoProdotto> findBySpedizioneId(Integer id){
		return contenutoRepository.findBySpedizioneId(id);
	}
	
	

	


}