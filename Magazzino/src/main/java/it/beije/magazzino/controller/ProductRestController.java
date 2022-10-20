package it.beije.magazzino.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.magazzino.model.Product;
import it.beije.magazzino.service.ProductService;


@RestController
@RequestMapping(value = "api")
public class ProductRestController {

	public ProductRestController() {
		System.out.println("creo un oggetto MyRestController...");
	}

	@Autowired
	private ProductService productService;

	 @GetMapping(value = "/product")
	  public  List<Product> Prodotti() {      
	      List<Product> prodotti = productService.findAll();
	     
	   
	      return prodotti; // /WEB-INF/views/home.jsp
	  }
	 
	 @PostMapping(value = "/prodottoById")
	  public  List<Product> ProdottoById( @RequestBody Product prod) {      
	      List<Product> prodotto = productService.findById(prod.getId());
	     
	   
	      return prodotto; // /WEB-INF/views/home.jsp
	  }

}
