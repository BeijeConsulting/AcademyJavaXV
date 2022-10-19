package it.beije.hopper.ecommerce.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.model.Order;
import it.beije.hopper.ecommerce.model.Product;
import it.beije.hopper.ecommerce.repository.OrderRepository;
import it.beije.hopper.ecommerce.service.ItemService;
import it.beije.hopper.ecommerce.service.OrderService;
import it.beije.hopper.ecommerce.service.ProductService;
import it.beije.hopper.model.User;
import it.beije.hopper.service.UserService;
import it.beije.hopper.spring.Carrello;

@RestController
@RequestMapping(value = "api")
public class OrderRestController {

	public OrderRestController() {
		System.out.println("creo un oggetto OrderRestController");
	}

	@Autowired
	private OrderService orderService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ProductService productService;

	@GetMapping(value = "/orders")
	public List<Order> orders() {

		List<Order> orders = orderService.getAll();

		return orders;
	}

	@GetMapping(value = "/carrello/{id}/{idp}")
	public Carrello cart(@PathVariable(value="id")Integer id,@PathVariable(value="idp")Integer idp,HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		Product product=productService.getById(idp);
		Carrello carrello=(Carrello)session.getAttribute("carrello");
		
		if(carrello==null) {
			Carrello emptyCart=new Carrello();
			carrello=emptyCart;
			carrello.add(product);
		}else {
			carrello.add(product);
		}
		
		
		session.setAttribute("carrello", carrello);
		session.setAttribute("id", id);

		return carrello;
	}

	@PostMapping(value = "/insertOrder")
	public Order insert(HttpServletRequest request) {

		HttpSession session = request.getSession();
		Carrello cart = (Carrello) session.getAttribute("carrello");
		Integer id = (Integer) session.getAttribute("id");
		
		Order order = new Order();
		LocalDateTime localDateTime=LocalDateTime.now();
		double amount = 0;
		
		for (int i = 0; i < cart.size(); i++) {
			amount += cart.getProduct(i).getPrice();
		}
		order.setUserId(id);
		order.setDatetime(localDateTime);
		order.setAmount(amount);
		order.setPromo(null);

		
		orderService.insert(order);
		itemService.orderItem(order, cart);
		return order;
	}	
}
