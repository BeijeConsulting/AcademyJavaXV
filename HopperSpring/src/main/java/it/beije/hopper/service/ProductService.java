package it.beije.hopper.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.ecommerce.model.Product;
import it.beije.hopper.model.User;
import it.beije.hopper.repository.ProductRepository;
import it.beije.hopper.repository.UserRepository;


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


	public List<Product> loadProduct() {

		
		List<Product> product = productRepository.findAll();
		
		System.out.println("loadProduct : " + product);
		
		return product;
	}

}
