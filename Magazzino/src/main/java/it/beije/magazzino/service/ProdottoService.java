package it.beije.magazzino.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;

@Service
public class ProdottoService {

	@Autowired ProdottoRepository prodottoRepository;
	
	public Prodotto getById(Integer id) throws Exception {
		Optional<Prodotto> prodotto=prodottoRepository.findById(id);
		if(!prodotto.isPresent())
			throw new Exception();
		return prodotto.get();
	}
}
