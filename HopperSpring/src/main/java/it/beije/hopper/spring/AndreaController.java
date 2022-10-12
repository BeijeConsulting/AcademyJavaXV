package it.beije.hopper.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class AndreaController {

	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());

		return "login"; // /WEB-INF/views/beije.jsp
	}
	
	@RequestMapping(value="prodotti",method=RequestMethod.GET)
	public String welcome(HttpServletRequest request ,Model model) {
		Carrello carrello=new Carrello();
		Product prod=new Product();
		prod.setName("Cappello NY");
		prod.setDesc("Bello");
		prod.setPrice(15.00);
		
		List<Product> lista=new ArrayList<>();
		
		lista.add(prod);
		model.addAttribute("products", lista);
		model.addAttribute("cartsize",carrello.size());
		model.addAttribute("cart",carrello);
		
		return "prodotti";
	}
	
	@RequestMapping(value="addcart",method=RequestMethod.GET)
	public String cart(HttpServletRequest request,Model model) {
		
		Carrello carrello=(Carrello)model.getAttribute("cart");
		int cartsize=(Integer)model.getAttribute("cartsize");
		Product prod=(Product)model.getAttribute("prod");
		
		carrello.add(prod);
		
		model.addAttribute("cart", carrello);
		return "prodotti";
	}
	
	
	
}
