package it.beije.magazzino.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value = {"/all_products"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		List<Product> products = productService.listAllProduct();
		
		if(products != null && products.size() > 0) {
			model.addAttribute("products" , products);
		}else {
			model.addAttribute("error" , "Non ci sono oggeti nel magazzino");
		}
	
		return "list_all_products"; 
	}
}
