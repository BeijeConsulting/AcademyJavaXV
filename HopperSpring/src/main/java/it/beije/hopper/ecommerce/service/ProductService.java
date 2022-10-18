package it.beije.hopper.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.ecommerce.model.Product;
import it.beije.hopper.ecommerce.repository.ProductRepository;
import it.beije.hopper.model.User;
import it.beije.hopper.repository.UserRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Integer id) {
		Optional<Product> u = productRepository.findById(id);
		
		if (!u.isPresent()) throw new IllegalArgumentException("User non trovato con id " + id);

		return u.get();
	}

}
