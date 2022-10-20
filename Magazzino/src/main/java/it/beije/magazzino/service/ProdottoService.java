package it.beije.magazzino.service;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProdottoService {

	@Autowired
	private ProdottoRepository ProdottoRepository;


	public ProdottoService() {
		System.out.println("creo un oggetto ProdottoService...");
	}
	

	
	/*public List<Prodotto> findByTipologia(String tipologia) {
		return ProdottoRepository.findtipologia(tipologia);
	}*/

	public List<Prodotto> getAll() {
		return ProdottoRepository.findAll();
	}


	public Prodotto findById(Integer id) throws Exception {
		Optional<Prodotto> prodotto=ProdottoRepository.findById(id);
		if(!prodotto.isPresent())
			throw new Exception();
		return prodotto.get();
	}


	public void insert(Prodotto prodotto) {
		ProdottoRepository.save(prodotto);
	}

	public void delete(Integer id) {
		ProdottoRepository.deleteById(id);
	}
}
