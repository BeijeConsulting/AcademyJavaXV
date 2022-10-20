package it.beije.magazzino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.beije.magazzino.model.Product;
import it.beije.magazzino.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public ProductService() {
		System.out.println("creo un oggetto ProductService...");
	}

	public List<Product> findAll() {
		
		return productRepository.findAll();
	}

	public List<Product> findById(int prodotto) {
		return productRepository.findById(prodotto);
	}
	
	public Product save(Product prod) {
		return productRepository.save(prod);
	}
	


}