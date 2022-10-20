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
	
	public List<Prodotto> getAllProduct(){		
		return prodottoRepository.findAll();
	}
	
	public Optional<Prodotto> getProductsById(Integer id){
		return prodottoRepository.findById(id);
	}
	
	public void saveArticle(Prodotto prodotto) {
		prodottoRepository.save(prodotto);
	}
	
	public void updateProductById(Prodotto prodotto, Integer id){
		prodottoRepository.save(prodotto, id);
	}
	
	public void deleteProduct(Prodotto prodotto) {
		prodottoRepository.delete(prodotto);
	}
	
}
