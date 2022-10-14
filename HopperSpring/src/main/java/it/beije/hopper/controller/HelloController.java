package it.beije.hopper.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.beije.hopper.model.Order;
import it.beije.hopper.model.Product;
import it.beije.hopper.service.OrderService;
import it.beije.hopper.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.hopper.model.User;
import it.beije.hopper.service.UserService;

import java.util.List;


@Controller
public class HelloController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;

	public HelloController() {
		System.out.println("creo un oggetto HelloController...");
	}
	
	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());

		return "home"; // /WEB-INF/views/home.jsp
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("GET login...");

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session,
			@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false) String password,
			Model model) {
		
		System.out.println("POST login...");
		
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		
		if (username != null && username.length() > 0 && password != null && password.length() > 0) {
			//verifico credenziali su DB...
			User loggedUser = userService.findByEmailAndPassword(username, password);
			if (loggedUser != null) {
//			if (username.equalsIgnoreCase("ivo@beije.it") && password.equalsIgnoreCase("1234")) { //OK
//				model.addAttribute("fname", "Pippo");
//				model.addAttribute("lname", "Rossi");
				
				//carico dettaglio utente...
				//User loggedUser = userService.loadUser(username);
				
				model.addAttribute("loggedUser", loggedUser);

				List<Product> listaProdotti = productService.findAll();
				System.out.println("lista prodotti: " + listaProdotti);
				model.addAttribute("products", listaProdotti);

				if(loggedUser.getAdmin()==1){
					List<Order> listaOrdini = orderService.findAll();
					System.out.println("lista ordini: " + listaOrdini);
					model.addAttribute("orders", listaOrdini);
					return "welcomeAdmin";
				}else{
					List<Order> listaOrdini = orderService.findByUserId(loggedUser.getId());
					System.out.println("lista ordini: " + listaOrdini);
					model.addAttribute("orders", listaOrdini);
					return "welcomeUser";
				}
			} else { //KO
				model.addAttribute("errore", "CREDENZIALI ERRATE");
			}
		} else {
			model.addAttribute("errore", "INSERIRE ENTRAMBE LE CREDENZIALI");
		}

		return "home";
	}

}
