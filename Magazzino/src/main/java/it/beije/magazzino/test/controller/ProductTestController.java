package it.beije.magazzino.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.magazzino.model.Product;
import it.beije.magazzino.service.ProductService;

@Controller
public class ProductTestController {

	@Autowired
	ProductService productService;

	@GetMapping(value = "/home_ajax")
	public String home() {
		return "/test/home";
	}

	@GetMapping(value = "/list_all_products_page")
	public String listAllProductApi() {
		System.out.println("POST registrazione");

		return "/test/list_all_products";
	}

	//Restituisce la lista di tutti i prodotti
	@RequestMapping(value = {"/all_products_apiT"}, method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProductsAPITest(HttpServletRequest request, Model model) {
		return ResponseEntity.ok(productService.listAllProduct());
	}

	//Restituisce la lista di tutti i prodotti
	@RequestMapping(value = {"/show_description_page"}, method = RequestMethod.GET)
	public String showDescriptionPage(HttpServletRequest request, Model model) {
		return "/test/show_description";
	}

	//Restituisce il dettaglio del prodotto tramite ID
	@RequestMapping(value = {"/show_description_apiT/{id}"}, method = RequestMethod.GET)
	public ResponseEntity<Product> showDescriptionGetApi(@PathVariable Integer id ) {
		//Cerca il prodotto selezionato
		if(id!= null && id > 0) {

			Product product = productService.getProductById(id);
			if(product != null) {
				return ResponseEntity.ok(product);
			}else {
				throw new RuntimeException("Prodotto non presente in magazzino");
			}

		}else {
			throw new RuntimeException("Inserimento non valido");
		}
	}

	@GetMapping(value = "/add_product_page")
	public String addProductPage() {
		return "/test/add_new_products";
	}

	//Metodo per la registrazione di un prodotto a magazzino
	@RequestMapping(value = {"/add_new_product_api"}, method = RequestMethod.POST)
	public ResponseEntity<Product> addProductPostApi(@RequestBody Product product){
		Product addProduct = productService.addProduct(product.getName(), product.getTypology(), product.getQuantity(), product.getDescription());	
		return ResponseEntity.ok(addProduct);
	}

	@GetMapping(value = "/alter_product_page")
	public String alterProductPage() {
		return "/test/alter_product";
	}

	//Restituisce il dettaglio del prodotto tramite ID
	@RequestMapping(value = {"/alter_product_api"}, method = RequestMethod.POST)
	public ResponseEntity<Product> alterProductPost(@RequestBody Product product){

		product = productService.alterProduct(product);

		if(product != null) {
			return ResponseEntity.ok(product);
		}else{
			throw new RuntimeException("Ci sono stati degli errori durante la modifica");
		}
	}

	@GetMapping(value = "/delete_product_page")
	public String deleteProductPage() {
		return "/test/delete_product";
	}

	//Restituisce il dettaglio del prodotto tramite ID
	@RequestMapping(value = {"/search_by_name"}, method = RequestMethod.GET)
	public ResponseEntity<List<Product>> deleteProductGet(
			@RequestParam(name = "name", required = false) String name){

		List<Product> products = productService.listProducyByName(name);

		if(products != null) {
			return ResponseEntity.ok(products);
		}else{
			throw new RuntimeException("Ci sono stati degli errori durante il caricamento dei prodotti");
		}
	}

	//Restituisce il dettaglio del prodotto tramite ID
	@RequestMapping(value = {"/delete_product_api/{id}"}, method = RequestMethod.POST)
	public ResponseEntity<Product> deleteProductPost(@PathVariable Integer id){

		Product product = productService.getProductById(id);

		if(product != null) {
			productService.deleteProduct(product.getId());
			return ResponseEntity.ok(product);
		}else{
			throw new RuntimeException("Ci sono stati degli errori durante la cancellazione");
		}
	}

	@GetMapping(value = "/list_product_by_typology_page")
	public String listProductByTypologyPage() {
		return "/test/list_product_by_typology";
	}

	@RequestMapping(value = {"/list_product_by_typology_api"}, method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listProductByTypology(
			@RequestParam(name = "typology", required = false) String typology) {

		//Mostra la lista dei prodotti presenti in magazzino
		List<Product> products = productService.listByTypology(typology);
		if(products != null && products.size() > 0) {
			return ResponseEntity.ok(products);
		}else {
			throw new RuntimeException("Errore durante il caricamento");
		}

	}
	
	@GetMapping(value = "/list_product_by_name_description_page")
	public String listProductByNameDescriptionPage() {
		return "/list_product_by_name_description";
	}

	@RequestMapping(value = {"/list_product_by_name_description_api"}, method = RequestMethod.GET)
	public String listProductByNameDescription(
			HttpServletRequest request, 
			Model model,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "description", required = false) String description) {

		//Mostra la lista dei prodotti presenti in magazzino
		List<Product> products = productService.listByNameDescription(name, description);

		if(products != null && products.size() > 0) {
			model.addAttribute("products" , products);
		}else {
			model.addAttribute("error" , "Non ci sono oggeti nel magazzino con questi parametri");
		}

		return "list_product_by_name_description";
	}

}
