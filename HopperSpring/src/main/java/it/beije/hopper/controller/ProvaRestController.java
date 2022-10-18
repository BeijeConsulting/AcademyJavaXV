package it.beije.hopper.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.hopper.ecommerce.repository.OrderRepository;
import it.beije.hopper.model.User;
import it.beije.hopper.service.UserService;


//@Controller se vuoi vedere pagina jsp
@RestController
//@RequestMapping(value = "testrest")
public class ProvaRestController {
	
	@Autowired
	private UserService userService;

	public ProvaRestController() {
		System.out.println("creo un oggetto TestController...");
	}
	

	@GetMapping(value="/getlist")
	public List<User> test(Locale locale, Model model) {
		System.out.println("test : " + locale);
		
		List<User> lista = userService.findAll();
		System.out.println("lista : " + lista);
		//model.addAttribute("lista", lista);
		
		return lista;
	}
	
	@PostMapping(value="/insertuser")
	public User insert(@RequestBody User user) {
		System.out.println("POST insertUser : " + user);
		
		userService.save(user);
		System.out.println("user post save : " + user);
		
		return user;
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
