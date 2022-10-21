package it.beije.magazzino.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@PostMapping(value = "/add_new_product")
	public Product addProduct(@RequestBody Product product) {	
		return productService.addProduct(product);		
	}
	
	@PutMapping(value = "/alter_product/{id}")
	public Product alterProduct(
			@PathVariable(name = "id") Integer id,
			@RequestBody Product product) {	
		
	if (id.compareTo(product.getId()) == 0) {//OK modifico
		return productService.alterProduct(product);	

		} else
			throw new IllegalArgumentException("id non corrispondenti");		
	}
	
	@DeleteMapping(value = "/delete_product/{id}")
	public String deleteUser(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE deleteUser : " + id);
		
		if(productService.deleteProduct(id)) {
			return "{\"message\":\"rimosso user " + id + "\"}";
		}else {
			throw new IllegalArgumentException("id non corrispondenti");
		}
		
	}
	
	//@RequestMapping(value = {"/list_product_by_typology/{typology}"}, method = RequestMethod.GET)
	@GetMapping(value = "/list_product_by_typology/{typology}")
	public List<Product> listProductByTypology(@PathVariable(name = "typology") String typology) {
		return productService.listByTypology(typology);
	}
	
	
	//@RequestMapping(value = {"/list_product_by_name_description"}, method = RequestMethod.GET)
	@GetMapping(value = "/list_product_by_name/{name}")
	public List<Product> listProductByName(
			@PathVariable(name = "name") String name){
		return  productService.listByNameDescription(name, null);
	}
	
	@GetMapping(value = "/list_product_by_description/{description}")
	public List<Product> listProductByDescription(
			@PathVariable(name = "description") String description){
		return  productService.listByNameDescription(null, description);
	}
	
	@GetMapping(value = "/list_product_by_name_description")
	public List<Product> listProductByNameDescription(
			HttpServletRequest request,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "description") String description){
		return  productService.listByNameDescription(name, description);
	}
	
}
