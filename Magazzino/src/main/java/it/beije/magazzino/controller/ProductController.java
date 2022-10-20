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
	

}
