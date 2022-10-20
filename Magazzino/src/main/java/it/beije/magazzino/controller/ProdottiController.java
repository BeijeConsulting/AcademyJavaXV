package it.beije.magazzino.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.service.ProdottoService;


@Controller
public class ProdottiController {
	
	@Autowired
	ProdottoService prodottoService;
	
	@RequestMapping(value = "allProducts", method = RequestMethod.GET)
	public String allProducts(HttpServletRequest request, Model model) {
		System.out.println("Page request: " + request.getRequestURI());
				
		List<Prodotto> prodotti = prodottoService.getAllProduct();
		model.addAttribute("prodotti", prodotti);
		return "product";
	}
	
	@RequestMapping(value = "productsById", method = RequestMethod.GET)
	public String productsById(HttpServletRequest request, Model model) {
		System.out.println("Page request: " + request.getRequestURI());
		
		Optional<Prodotto> articolo = prodottoService.getProductsById(2);
		model.addAttribute("articolo", articolo);
		return "article";
	}
	
	@RequestMapping(value = "insertProduct", method = RequestMethod.GET)
	public String insertProduct(HttpServletRequest request, Model model) {
		System.out.println("Page request: " + request.getRequestURI());
		
		Optional<Prodotto> articolo = prodottoService.getProductsById(2);
		model.addAttribute("articolo", articolo);
		return "article";
	}
	
	@RequestMapping(value = "updateProduct", method = RequestMethod.GET)
	public String updateProduct(HttpServletRequest request, Model model) {
		System.out.println("Page request: " + request.getRequestURI());
		
		Optional<Prodotto> articolo = prodottoService.getProductsById(2);
		model.addAttribute("articolo", articolo);
		return "article";
	}
	
	@RequestMapping(value = "deleteProduct", method = RequestMethod.GET)
	public void deleteProduct(HttpServletRequest request, Model model) {
		System.out.println("Page request: " + request.getRequestURI());
		
		model.addAttribute("rimosso", rimosso);
	}
	
}
