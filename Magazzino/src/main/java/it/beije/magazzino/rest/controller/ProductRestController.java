package it.beije.magazzino.rest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.magazzino.model.Product;
import it.beije.magazzino.service.ProductService;

@RestController
@RequestMapping(value = "api")
public class ProductRestController {

	@Autowired
	ProductService productService;
	
	//Lista dei prodotti
	@GetMapping(value = "/all_products")
	public List<Product> allProducts() {	
		return productService.listAllProduct();			
	}
	
	//Mostra dettaglio del prodotto avente codice ID
	@GetMapping(value = "/show_description/{id}")
	public Product showDescription(@PathVariable(name = "id") String id) {	
		return productService.getProductById(id);			
	}

	//Mostra dettaglio del prodotto avente codice ID
	@GetMapping(value = "/add_new_product")
	public Product addProduct(@RequestBody Product product) {	
		return productService.addProduct(product);		
	}
	
	
}
