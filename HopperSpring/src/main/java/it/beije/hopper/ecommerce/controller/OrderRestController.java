package it.beije.hopper.ecommerce.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.hopper.ecommerce.model.Order;
import it.beije.hopper.ecommerce.model.Product;
import it.beije.hopper.ecommerce.repository.OrderRepository;
import it.beije.hopper.ecommerce.service.OrderService;
import it.beije.hopper.model.User;


@RestController
@RequestMapping(value = "api")
public class OrderRestController {

	public OrderRestController() {
		System.out.println("creo un oggetto OrderRestController");
	}

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderService orderService;

	@GetMapping(value="/orders")
	public List<Order> orders() {
		
		List<Order> orders = orderRepository.findAll();
		
		return orders;
	}
	
	@PostMapping(value = "/insertorder")								//NON VA
	public Order insertOrder(@RequestBody Order order) {
		System.out.println("POST insertOrder : " + order);
		
		orderService.save(order);
		System.out.println("order post save : " + order);
		
		return order;
	}
	
	@PutMapping(value = "/orders/{id}")
	public Order updateOrder(@PathVariable(name = "id") Integer id, @RequestBody Order newData) {
		System.out.println("POST updateOrder id : " + id + " : " + newData);
		
		if (id.compareTo(newData.getId()) == 0) {//OK modifico
			
			Order order = orderService.findById(id);
			
			
			BeanUtils.copyProperties(newData, order, "id");
			
			orderService.save(order);
			System.out.println("user with new data : " + order);

			return order;
		} else
			throw new IllegalArgumentException("id non corrispondenti");
	}
	
	@DeleteMapping(value = "/orders/{id}")
	public String deleteOrder(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE deleteOrder : " + id);
		
		orderRepository.deleteById(id);
		
		return "{\"message\":\"rimosso user " + id + "\"}";
	}
	
	
}
