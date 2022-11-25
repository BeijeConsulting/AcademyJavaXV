package it.beije.magazzino.controller.no_rest;


import it.beije.magazzino.model.Product;
import it.beije.magazzino.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class MainController {

	public MainController() {
		System.out.println("creo un oggetto MainController...");
	}

	@Autowired
	ProductService productService;

//	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
//	public String index(HttpServletRequest request, Model model) {
//		System.out.println("Main Page Requested : " + request.getRequestURI());
//		List<Product> products = productService.findAll();
//		return "main"; // /WEB-INF/views/beije.jsp
//	}

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {

		return "js/main";
	}


}
