package it.beije.hopper.ecommerce.rest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.hopper.ecommerce.model.Product;
import it.beije.hopper.service.ProductService;

@RestController
@RequestMapping(value = "api")

public class ProductRestController {
	
	@Autowired
	ProductService productService;
		
	@GetMapping(value = "/products")
	public List<Product> seeAllProducts() {
		return productService.loadProducts();
	}
	
	@GetMapping(value = "/find_product/{product_name}")
	public List<Product> findProduct(@PathVariable(name = "product_name") String product_name) {
		if(product_name != null && product_name.length() > 0 ) {
			System.out.println(product_name);
			return productService.searchProducts(product_name);	
		}
		return null;
	}
	
}
