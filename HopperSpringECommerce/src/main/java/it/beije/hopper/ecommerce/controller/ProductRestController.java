package it.beije.hopper.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.hopper.ecommerce.model.Product;
import it.beije.hopper.ecommerce.service.ProductService;
@RequestMapping("product")
@RestController
public class ProductRestController {

	@Autowired ProductService productService;
	
	@GetMapping(value="getbyid/{id}")
	public Product getById(@PathVariable(value="id")Integer id) throws Exception {
		Product product=productService.getById(id);
		return product;
	}
}
