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
public class HelloController {

	public HelloController() {
		System.out.println("creo un oggetto HelloController...");
	}

	@Autowired
	ProductService productService;

	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		List<Product> products = productService.findAll();
		System.out.println("Products:" + products);

		return "hello"; // /WEB-INF/views/beije.jsp
	}



}
