package it.beije.magazzino.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;

@Service
public class ProdottoService {
	
	@Autowired
	private ProdottoRepository prodottoRepository;

	public Prodotto findById(Integer id) {
		Optional<Prodotto> p = prodottoRepository.findById(id);
		
		if (!p.isPresent()) throw new IllegalArgumentException("Prodotto non trovato con id " + id);

		return p.get();
	}

}
