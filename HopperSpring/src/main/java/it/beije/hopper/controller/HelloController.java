package it.beije.hopper.controller;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.beije.hopper.model.Item;
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
				session.setAttribute("products", listaProdotti);

				if(loggedUser.getAdmin()==1){
					List<Order> listaOrdini = orderService.findAll();
					System.out.println("lista ordini: " + listaOrdini);
					session.setAttribute("orders", listaOrdini);

					return "welcomeAdmin";
				}else{
					List<Order> listaOrdini = orderService.findByUserId(loggedUser.getId());
					System.out.println("lista ordini: " + listaOrdini);
					session.setAttribute("orders", listaOrdini);
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

	@RequestMapping(value = "/newProduct", method = RequestMethod.POST)
	public String newProduct( @RequestParam(name = "nome", required = false) String nome,
							  @RequestParam(name = "descrizione", required = false) String descrizione,
							  @RequestParam(name = "prezzo", required = false) Double prezzo,
							  @RequestParam(name = "quantita", required = false) Integer quantita,
							  @RequestParam(name = "rate", required = false) Integer rate,
							  @RequestParam(name = "promo", required = false) Integer promo,
							  HttpSession session,
							  Model model) {

		System.out.println("Inserisco nuovo Prodotto...");
		Product newP = new Product();
		newP.setName(nome);
		newP.setDesc(descrizione);
		newP.setPrice(prezzo);
		newP.setQuantity(quantita);
		newP.setRating(rate);
		newP.setPromo(promo);
		productService.saveProduct(newP);

		model.addAttribute("result", "HAI INSERITO UN NUOVO PRODOTTO!!!");

		List<Product> listaProdotti = productService.findAll();
		System.out.println("lista prodotti: " + listaProdotti);
		session.setAttribute("products", listaProdotti);
		return "welcomeAdmin";
	}
	@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
	public String editProduct(	@RequestParam(name = "id") Integer id,
							  	@RequestParam(name = "campo") String campo,
								@RequestParam(name = "valore") String valore,
								HttpSession session,
								Model model) {

		System.out.println("Modifico un Prodotto");
		Product p = productService.loadProduct(id);
		switch (campo){
			case "nome": p.setName(valore);break;
			case "descrizione": p.setDesc(valore);break;
			case "prezzo": p.setPrice(Double.parseDouble(valore));break;
			case "quantita": p.setQuantity(Integer.parseInt(valore));break;
			case "rating": p.setRating(Integer.parseInt(valore));break;
			case "promo": p.setPromo(Integer.parseInt(valore));break;
		}

		productService.saveProduct(p);

		model.addAttribute("result", "HAI MODIFICATO IL PRODOTTO!!!");

		List<Product> listaProdotti = productService.findAll();
		System.out.println("lista prodotti: " + listaProdotti);
		session.setAttribute("products", listaProdotti);
		return "welcomeAdmin";
	}
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public String deleteProduct( @RequestParam(name = "id") Integer id,
								 HttpSession session,
								 Model model) {
		System.out.println("GET login...");
		Product p = productService.loadProduct(id);
		productService.deleteProduct(p);

		model.addAttribute("result", "HAI ELIMINATO IL PRODOTTO!!!");

		List<Product> listaProdotti = productService.findAll();
		System.out.println("lista prodotti: " + listaProdotti);
		session.setAttribute("products", listaProdotti);
		
		return "welcomeAdmin";
	}
	@RequestMapping(value = "/infOrdine", method = RequestMethod.POST)
	public String infOrdine( @RequestParam(name = "id") Integer id,
							 Model model) {
		
		System.out.println("GET login...");
		Order order = orderService.loadOrder(id);
		String dettaglio = "";
		for (Item i: order.getItems()) {
			dettaglio +="- " + i.getName() + " " + i.getDesc() + " " + i.getPrice() + " " + i.getQuantity() + " " + i.getPromo() + " [TOT: "+ i.getPrice()*i.getQuantity() +"]\n";
		}
		model.addAttribute("result", "DETTAGLIO ORDINE "+id+":\n" + dettaglio);
		return "welcomeAdmin";
	}

}
