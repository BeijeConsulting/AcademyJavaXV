package it.beije.hopper.controller;

import java.util.List;
import java.util.Locale;

import it.beije.hopper.service.ItemService;
import it.beije.hopper.service.OrderService;
import it.beije.hopper.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.hopper.service.UserService;


@Controller
public class TestController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ItemService itemService;

	public TestController() {
		System.out.println("creo un oggetto TestController...");
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		System.out.println("test : " + locale);

		List<String> lista = userService.loadList();
		System.out.println("lista : " + lista);
		model.addAttribute("lista", lista);
		
		return "testosterone";
	}

}
