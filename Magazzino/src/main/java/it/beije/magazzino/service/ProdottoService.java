package it.beije.magazzino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;

@Service
public class ProdottoService {

	@Autowired
	ProdottoRepository prodottoRepository;
	
	public List<Prodotto> findAllArticles()	{ return prodottoRepository.findAll(); }

	public Prodotto findSpecificArticle(Integer id){
		return prodottoRepository.getById(id);
	}

	public void insert(Prodotto prodotto) { prodottoRepository.save(prodotto); }

	public List<Prodotto> getArticleByType(String tipologia){
		return prodottoRepository.getProdottoByType(tipologia);
	}

	public Prodotto getArticleByName(String name) { return prodottoRepository.getProdottoByName(name); }

	public void deleteSpecificArticle(Integer id){
		prodottoRepository.deleteById(id);
	}
}
