package it.beije.magazzino.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.magazzino.model.Product;
import it.beije.magazzino.service.ProductService;


@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping(value = "/home")
	public String home() {
		System.out.println("POST registrazione");

		return "home";
	}

	//Restituisce la lista di tutti i prodotti
	@RequestMapping(value = {"/all_products"}, method = RequestMethod.GET)
	public String listAllProducts(HttpServletRequest request, Model model) {
		List<Product> products = productService.listAllProduct();

		if(products != null && products.size() > 0) {
			model.addAttribute("products" , products);
		}else {
			model.addAttribute("error" , "Non ci sono oggeti nel magazzino");
		}

		return "list_all_products"; 
	}

	//Restituisce il dettaglio del prodotto tramite ID
	@RequestMapping(value = {"/show_description"}, method = RequestMethod.GET)
	public String showDescriptionGet(
			HttpServletRequest request, 
			Model model,
			@RequestParam(name = "id_product", required = false) String id_product) {

		//Mostra la lista dei prodotti presenti in magazzino
		List<Product> products = productService.listAllProduct();
		if(products != null && products.size() > 0) {
			model.addAttribute("products" , products);
		}else {
			model.addAttribute("error" , "Non ci sono oggeti nel magazzino");
		}

		//Cerca il prodotto selezionato
		if(id_product != null && id_product.length() > 0) {
			try {
				Integer id = Integer.parseInt(id_product);
				Product product = productService.getProductById(id);
				if(product != null) {
					model.addAttribute("product" , product);
				}else {
					model.addAttribute("error" , "Prodotto non presente in magazzino");
				}

			}catch(NumberFormatException ex){
				model.addAttribute("error" , "Formato ID non valido, inserire un numero");
			}
		}else {
			model.addAttribute("error" , "Inserimento non valido");
		}

		return "show_description";
	}

	//Metodo per la registrazione di un prodotto a magazzino
	@RequestMapping(value = {"/add_new_product"}, method = RequestMethod.POST)
	public String addProductPost(
			HttpServletRequest request, 
			Model model,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "typology", required = false) String typology,
			@RequestParam(name = "quantity", required = false) String quantity,
			@RequestParam(name = "description", required = false) String description){

		if(productService.checkParameters(name, typology, quantity)) {
			Product product = productService.addProduct(name, typology, quantity, description);
			if(product != null) {
				model.addAttribute("product", product);
				model.addAttribute("registered" , "Prodotto aggiunto correttamente");
			}else {
				model.addAttribute("error", "Attenzione, qualcosa è andato storto. Controllare i dati inseriti e che il prodotto non sia gia' presente in magazzino");	
			}
		}else {
			model.addAttribute("error", "Attenzione, inserire tutti i campi obbligatori (nome, password e quantità)");

		}		
		return "add_new_product";
	}

	@RequestMapping(value = {"/add_new_product"}, method = RequestMethod.GET)
	public String addProductGet(HttpServletRequest request) {

		return "add_new_product";
	}


	//Restituisce il dettaglio del prodotto tramite ID
	@RequestMapping(value = {"/alter_product"}, method = RequestMethod.GET)
	public String alterProductGet(
			HttpServletRequest request, 
			Model model,
			@RequestParam(name = "id_product", required = false) String id_product) {

		Product product = productService.getProductById(id_product);
		if(product != null) {
			model.addAttribute("product", product);
		}else {
			model.addAttribute("error", "Prodotto non trovato");
		}

		return "alter_product";
	}

	//Restituisce il dettaglio del prodotto tramite ID
	@RequestMapping(value = {"/alter_product"}, method = RequestMethod.POST)
	public String alterProductPost(
			HttpServletRequest request, 
			Model model,
			@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "typology", required = false) String typology,
			@RequestParam(name = "quantity", required = false) String quantity,
			@RequestParam(name = "name", required = false) String description){

		Product product = productService.setProduct(id, name, typology, quantity, description);
		product = productService.alterProduct(product);

		if(product != null) {
			model.addAttribute("product" , product);
			model.addAttribute("alteredProduct", "Modifica avvenuta con successo");
		}else{
			model.addAttribute("error", "Errore, qualcosa è andato storto, controllare i modificati");
		}

		return "alter_product";
	}

	//Restituisce il dettaglio del prodotto tramite ID
	@RequestMapping(value = {"/delete_product"}, method = RequestMethod.GET)
	public String deleteProductGet(
			HttpServletRequest request, 
			Model model,
			@RequestParam(name = "name", required = false) String name){

		List<Product> products = productService.listProducyByName(name);

		if(products != null) {
			model.addAttribute("products" , products);
		}else{
			model.addAttribute("error", "Errore, non sono stati trovati prodotti con questo nome");
		}

		return "delete_product";
	}

	//Restituisce il dettaglio del prodotto tramite ID
	@RequestMapping(value = {"/delete_product"}, method = RequestMethod.POST)
	public String deleteProductPost(
			HttpServletRequest request, 
			Model model,
			@RequestParam(name = "id", required = false) String id){

		Product product = productService.getProductById(id);

		if(product != null) {
			productService.deleteProduct(product.getId());
			model.addAttribute("delete" , "Prodotto rimosso dal database");
		}else{
			model.addAttribute("error", "Errore, non sono stati trovati prodotti con questo nome");
		}

		return "delete_product";
	}

	
	@RequestMapping(value = {"/list_product_by_typology"}, method = RequestMethod.GET)
	public String listProductByTypology(
			HttpServletRequest request, 
			Model model,
			@RequestParam(name = "typology", required = false) String typology) {

		//Mostra la lista dei prodotti presenti in magazzino
		List<Product> products = productService.listByTypology(typology);
		if(products != null) for(Product p : products) System.out.println(p);
		if(products != null && products.size() > 0) {
			model.addAttribute("products" , products);
		}else {
			model.addAttribute("error" , "Non ci sono oggeti nel magazzino con questa tipologia");
		}

		return "list_product_by_typology";
	}

}
