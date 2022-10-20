package it.beije.magazzino.controller.no_rest;


import it.beije.magazzino.model.Product;
import it.beije.magazzino.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;


@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductController() {
		System.out.println("creo un oggetto ProductController...");
	}




	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Locale locale, Model model) {
		System.out.println("test : " + locale);
		List<Product> products = productService.findAll();
		System.out.println("Inside products() | .../products: " + products);
		model.addAttribute("products",products);
		return "product-list";
	}


	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String productsbyid(Locale locale, Model model) {
		System.out.println("test : " + locale);
		List<Product> products = productService.findAll();
		System.out.println("Inside products() | .../products: " + products);
		model.addAttribute("products",products);
		return "productbyid";
	}
	
//	@RequestMapping(value = "/test_rest", method = RequestMethod.GET)
//	@ResponseBody public List<User> testRest() {
//		System.out.println("GET test_rest...");
//
//		List<User> lista = userService.loadLastClients(LocalDate.now().minusMonths(1));
//		System.out.println("lista : " + lista);
//
//		return lista;
//	}
}
