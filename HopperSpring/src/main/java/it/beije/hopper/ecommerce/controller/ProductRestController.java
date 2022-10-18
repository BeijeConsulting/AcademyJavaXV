package it.beije.hopper.ecommerce.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.model.Product;
import it.beije.hopper.ecommerce.repository.ProductRepository;
import it.beije.hopper.ecommerce.service.ProductService;
import it.beije.hopper.model.User;
import it.beije.hopper.repository.UserRepository;
import it.beije.hopper.service.UserService;

@RestController
@RequestMapping(value = "api")
public class ProductRestController {
	
	@Autowired
	public ProductService productService;
	
	@Autowired
	public ProductRepository productRepository;
	
	@GetMapping(value="/products")
	public List<Product> orders() {
		
		List<Product> prodotti = productRepository.findAll();
		
		return prodotti;
	}
	
	@PostMapping(value = "/insertproduct")
	public Product insertProduct(@RequestBody Product product) {
		System.out.println("POST insertProduct : " + product);
		
		productService.save(product);
		System.out.println("product post save : " + product);
		
		return product;
	}
	
	@PutMapping(value = "/products/{id}")
	public Product updateProduct(@PathVariable(name = "id") Integer id, @RequestBody Product newData) {
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
	
	@DeleteMapping(value = "/products/{id}")
	public String deleteUser(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE deleteProduct : " + id);
		
		productRepository.deleteById(id);
		
		return "{\"message\":\"rimosso user " + id + "\"}";
	}

}
