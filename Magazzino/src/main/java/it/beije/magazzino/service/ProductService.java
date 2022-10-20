package it.beije.magazzino.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.magazzino.model.Product;
import it.beije.magazzino.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> listAllProduct(){
		return productRepository.findAll();
	}
	
	//Metodo Chiamato dal controller
	public Product getProductById(Integer id){
		Product product = productRepository.loadById(id);
	
		return  product;
	}
	
	//Metodo chiamato dal RestController
	public Product getProductById(String id_product){
		try {
			Integer id = Integer.parseInt(id_product);
			return getProductById(id);
		}catch(NumberFormatException ex){
			return null;
		}
	}
	
	//Aggiungere un nuovo prodotto al magazzino Controller
	public Product addProduct(String name, String typology, String quantity, String description) {
		try {
			Integer quantityInt = Integer.parseInt(quantity);
			Product checkProduct = productRepository.findByNameAndTypology(name, typology);
			
			if(checkProduct == null) {
				Product product = new Product();
				product.setName(name);
				product.setTypology(typology);
				product.setQuantity(quantityInt);
				product.setDescription(description);
				productRepository.save(product);
				return product;
			}else{
				return null;
			}
			
		}catch(NumberFormatException ex) {
			return null;
		}
	}

	public Product addProduct(String name, String typology, Integer quantity, String description) {
		Product checkProduct = productRepository.findByNameAndTypology(name, typology);

		if(checkProduct == null) {
			Product product = new Product();
			product.setName(name);
			product.setTypology(typology);
			product.setQuantity(quantity);
			product.setDescription(description);
			productRepository.save(product);
			return product;
		}else{
			return null;
		}
	}
	
	public Product addProduct(Product product) {
		if(!product.isEmpy() && product.checkParameters()) {
			return addProduct(product.getName(), product.getTypology(), product.getQuantity(), product.getDescription());
		}
		return null;	
	}
	
	public boolean checkParameters(String name, String typology, String quantity) {	
		if( !(name != null && name.length() > 0)) return false;
		if( !(typology != null && typology.length() > 0)) return false;
		if( !(quantity != null && quantity.length() > 0)) return false;
		
		return true;
	}
}
