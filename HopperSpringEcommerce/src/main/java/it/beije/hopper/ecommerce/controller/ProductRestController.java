package it.beije.hopper.ecommerce.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.hopper.ecommerce.model.Product;
import it.beije.hopper.model.User;
import it.beije.hopper.repository.UserRepository;
import it.beije.hopper.repository.ProductRepository;
import it.beije.hopper.service.UserService;
import it.beije.hopper.service.ProductService;


@RestController
@RequestMapping(value = "api")
public class ProductRestController {

	@Autowired
	public ProductService productService;
	
	@Autowired
	public ProductRepository productRepository;
	
	public ProductRestController() {
		System.out.println("creo un oggetto UserRestController");
	}
	
	@GetMapping(value = "/product/{id}")
	public Product getUser(@PathVariable(name = "id") Integer id) {
		System.out.println("GET getUser : " + id);
		
		Product product = productService.findById(id);
		System.out.println("product : " + product);
		
		return product;
	}
	
	@PostMapping(value = "/product")
	public Product insertUser(@RequestBody Product product) {
		System.out.println("POST insertProduct : " + product);
		
		productService.save(product);
		System.out.println("product post save : " + product);
		
		return product;
	}

	@PutMapping(value = "/product/{id}")
	public Product updateUser(@PathVariable(name = "id") Integer id, @RequestBody Product newData) {
		System.out.println("POST updateProduct id : " + id + " : " + newData);
		
		if (id.compareTo(newData.getId()) == 0) {//OK modifico
			
			Product product = productService.findById(id);
			
			
			BeanUtils.copyProperties(newData, product, "id");
			
			productService.save(product);
			System.out.println("user with new data : " + product);

			return product;
		} else
			throw new IllegalArgumentException("id non corrispondenti");
	}
	
	@DeleteMapping(value = "/product/{id}")
	public String deleteUser(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE deleteProduct : " + id);
		
		productRepository.deleteById(id);
		
		return "{\"message\":\"rimosso prodotto " + id + "\"}";
	}
}
