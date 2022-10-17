package it.beije.hopper.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.hopper.model.Order;
import it.beije.hopper.repository.OrderRepository;


@RestController
@RequestMapping(value = "api")
public class OrderRestController {

	public OrderRestController() {
		System.out.println("creo un oggetto OrderRestController");
	}

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping(value="/orders")
	public List<Order> orders() {
		
		List<Order> orders = orderRepository.findAll();
		
		return orders;
	}
}
