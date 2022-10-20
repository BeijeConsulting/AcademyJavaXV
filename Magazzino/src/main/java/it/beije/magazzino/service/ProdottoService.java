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
	private ProdottoRepository prodottoRepository;


	public ProdottoService() {
		System.out.println("creo un oggetto ProdottoService...");
	}

	public Optional<Prodotto> findById(Integer id) {
		return prodottoRepository.findById(id);
	}

	public List<Prodotto> findAll() {return prodottoRepository.findAll();}

	public void save(Prodotto p) {
		prodottoRepository.save(p);
	}

	public void delete(Prodotto p) {
		prodottoRepository.delete(p);
	}

    public List<Prodotto> findByTipologia(String tipologia) { return prodottoRepository.findByTipologia(tipologia);
    }

	public List<Prodotto> findByNomeOrDescrizione(String nome, String descrizione) {
		return prodottoRepository.findByNomeOrDescrizione(nome, descrizione);
	}
}
