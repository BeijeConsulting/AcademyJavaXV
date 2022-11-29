package it.beije.hopper.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.hopper.ecommerce.model.Order;
import it.beije.hopper.ecommerce.repository.OrderRepository;
import it.beije.hopper.ecommerce.service.OrderService;


@RestController
@RequestMapping(value = "api")
public class OrderRestController {

	public OrderRestController() {
		System.out.println("creo un oggetto OrderRestController");
	}

	@Autowired
	private OrderRepository orderRepository;
	private OrderService orderService;

	@GetMapping(value="/orders")
	public List<Order> orders() {
		
		//List<Order> orders = orderRepository.findAll();		//namedQuery
		List<Order> orders = orderService.getAll();			//criteriaQuery
		
		return orders;
	}
}
