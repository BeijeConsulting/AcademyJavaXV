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
	
	public List<Product> findByTipo(String tipo){
        List<Product> prod = productRepository.findByTipo(tipo);
        return prod;
    }
	
	
    
	
	public List<Product> findByDesc(String desc){
        List<Product> prod = productRepository.findByDesc(desc);
        return prod;
    }



	public List<Product> findByName(String nome) {
		List<Product> prod = productRepository.findByName(nome);
        return prod;
	}
	
	public List<Product> findByNameAndDesc(String name, String desc) {
		List<Product> prod = productRepository.findByNameAndDesc(name, desc);
        return prod;
	}

	
	


}