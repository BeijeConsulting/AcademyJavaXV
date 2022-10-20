package it.beije.magazzino.controller.no_rest;


import it.beije.magazzino.model.Product;
import it.beije.magazzino.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


	@RequestMapping(value = "/productbyid-form", method = RequestMethod.GET)
	public String productsbyidForm(@ModelAttribute("product") Product product, Locale locale, Model model) {
		System.out.println("test : " + locale);
		List<Product> products = productService.findAll();
		System.out.println("Inside products() | .../products: " + products);
		model.addAttribute("products",products);

		System.out.println("Product id: " + product.getId());

		return "productbyid-form";
	}

	@RequestMapping(value = "/productbyid", method = RequestMethod.GET)
	public String productsbyid(@ModelAttribute("product") Product product, Locale locale, Model model) {
		System.out.println("Inside /productbyid --- productsbyid");

		System.out.println("Product id: " + product.getId());

		Product productWithInfo = productService.findById(product.getId());
		System.out.println("Product found: " + productWithInfo);
		model.addAttribute("productWithInfo", productWithInfo);
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
