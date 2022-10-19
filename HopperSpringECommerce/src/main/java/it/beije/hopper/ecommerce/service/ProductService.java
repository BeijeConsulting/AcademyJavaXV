package it.beije.hopper.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.ecommerce.model.Product;
import it.beije.hopper.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired ProductRepository productRepository;
	
	public Product getById(Integer id) throws Exception {
		Optional<Product> product=productRepository.findById(id);
		if(!product.isPresent())
			throw new Exception();
		return product.get();
	}
	
	
	
}
