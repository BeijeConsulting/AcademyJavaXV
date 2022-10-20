package it.beije.magazzino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.magazzino.model.Product;
import it.beije.magazzino.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> listAllProduct(){
		return productRepository.findAll();
	}
	
	
	public Product getProductById(Integer id){
		Product product = productRepository.loadById(id);
	
		return  product;
	}
	
	public Product getProductById(String id_product){
		try {
			Integer id = Integer.parseInt(id_product);
			return getProductById(id);
		}catch(NumberFormatException ex){
			return null;
		}
	}
}
