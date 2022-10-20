package it.beije.magazzino.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import it.beije.magazzino.model.Product;
import it.beije.magazzino.repository.ProductRepository;
import it.beije.magazzino.service.ProductService;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	

	public ProductController() {
		System.out.println("creo un oggetto HelloController...");
	}
	
	
	
	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String hello(HttpServletRequest request) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());

		return "home";
	}
	
	
	  @RequestMapping(value = "/product", method = RequestMethod.GET)
	    public String index(HttpServletRequest request, Model model) {
	        System.out.println("Hello Page Requested : " + request.getRequestURI());

	        List<Product> product = productService.findAll();
	        model.addAttribute("product", product);
	       

	        return "prodotti"; // /WEB-INF/views/home.jsp

	    }
	  
	  @RequestMapping(value = "/prodottoById", method = RequestMethod.POST)
	    public String prodottoById(HttpServletRequest request, @RequestParam(name = "prodotto", required = false) int prodotto, Model model) {
	       
	        List<Product> prod = productService.findById(prodotto);
	        model.addAttribute("prodotto", prod);
	        return "prodotto"; // /WEB-INF/views/home.jsp
	    }
	  
	  @RequestMapping(value = "/addProd", method = RequestMethod.POST)
		public String insertUser(Product prodotto, Model model) {
				
			productRepository.save(prodotto);
			System.out.println("prodotto post save : " + prodotto);
			model.addAttribute("addProd", prodotto);
			
			return "home";
		}


}
