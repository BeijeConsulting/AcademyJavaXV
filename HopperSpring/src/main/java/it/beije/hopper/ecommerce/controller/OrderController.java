package it.beije.hopper.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.beije.hopper.model.Order;
import it.beije.hopper.repository.OrderRepository;


@Controller
public class OrderController {

	public OrderController() {
		System.out.println("creo un oggetto OrderController");
	}

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping(value="/orders")
	public String orders(Model model) {
		
		List<Order> orders = orderRepository.findAll();
		model.addAttribute("orders", orders);
		
		return "lista_ordini";		
	}
}
