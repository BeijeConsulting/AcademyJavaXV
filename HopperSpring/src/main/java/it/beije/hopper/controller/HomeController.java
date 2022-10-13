package it.beije.hopper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.model.Product;
import it.beije.hopper.model.User;
import it.beije.hopper.repository.ProductRepository;
import it.beije.hopper.repository.UserRepository;
import it.beije.hopper.service.ItemService;
import it.beije.hopper.service.ProductService;
import it.beije.hopper.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private ProductRepository userRepository;
	
	@Autowired
	private ProductService productService;
	
	//@Autowired
	private ItemService itemService;
	
	
	
	@RequestMapping(value = {"/ecommerce"}, method = RequestMethod.GET)
	public String registerGet(HttpServletRequest request, Model model) {
		List<Product> products = productService.loadProducts();
		//List<Item> cart = (List<Item>) model.getAttribute("cart");
		List<Item> cart = new ArrayList<Item>();
		model.addAttribute("products", products);
		
		String quantity = request.getParameter("quantity");
		System.out.println(quantity);
		String id = request.getParameter("button");
		System.out.println(id);
		//cart = itemService.addProduct(cart, id, quantity);
		model.addAttribute("products", products);
		
		return "home"; // /WEB-INF/views/beije.jsp
	}
	
	
//	@RequestMapping(value = {"/addProductHome"}, method = RequestMethod.GET)
//	public String addProductHome(HttpServletRequest request, Model model) {
//		
//		return "home"; // /WEB-INF/views/beije.jsp
//	}
}
