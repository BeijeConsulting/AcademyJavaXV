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



//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login() {
//		System.out.println("GET login...");
//
//		return "login";
//	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(HttpSession session,
//			@RequestParam(name = "username", required = false) String username,
//			@RequestParam(name = "password", required = false) String password,
//			Model model) {
//
//		System.out.println("POST login...");
//
//		System.out.println("username : " + username);
//		System.out.println("password : " + password);
//
//		if (username != null && username.length() > 0 && password != null && password.length() > 0) {
//			//verifico credenziali su DB...
//			User loggedUser = userService.findByEmailAndPassword(username, password);
//			if (loggedUser != null) {
////			if (username.equalsIgnoreCase("ivo@beije.it") && password.equalsIgnoreCase("1234")) { //OK
////				model.addAttribute("fname", "Pippo");
////				model.addAttribute("lname", "Rossi");
//
//				//carico dettaglio utente...
//				//User loggedUser = userService.loadUser(username);
//
//				model.addAttribute("loggedUser", loggedUser);
//
//				List<Order> lista = orderService.findByUserId(loggedUser.getId());
//				System.out.println("lista: " + lista);
//
//
//				model.addAttribute("orders", lista);
////				userService.findById(3);
//				//lista degli utenti con lo stesso cognome
//				//List<User> stessoCognome = userService.findByLastName(loggedUser.getLastName());
////				List<User> stessoCognome = userService.findByLastName(loggedUser.getLastName());
////				System.out.println("Same lastname: " + stessoCognome);
////				System.out.println("Last name of logged user: " + loggedUser.getLastName());
////				session.setAttribute("lastNames", stessoCognome);
//				return "welcome";
//			} else { //KO
//				model.addAttribute("errore", "CREDENZIALI ERRATE");
//			}
//		} else {
//			model.addAttribute("errore", "INSERIRE ENTRAMBE LE CREDENZIALI");
//		}
//
//		return "login";
//	}

}
