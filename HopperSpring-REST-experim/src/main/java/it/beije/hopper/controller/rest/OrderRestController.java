package it.beije.hopper.controller.rest;

import java.time.LocalDateTime;
import java.util.List;

import it.beije.hopper.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import it.beije.hopper.model.Order;
import it.beije.hopper.repository.OrderRepository;


@RestController
@RequestMapping(value = "api")
public class OrderRestController {

	@Autowired
	private OrderService orderService;

	public OrderRestController() {
		System.out.println("creo un oggetto OrderRestController");
	}



	@GetMapping(value="/orders")
	public List<Order> orders() {
		
//		List<Order> orders = orderRepository.findAll();
		return orderService.findAll();
	}

	@GetMapping( value="/order/{order_id}")
	public Order getOrder(@PathVariable(name="order_id") Integer id){
		Order order = orderService.findById(id);
		System.out.println("Order: " + order);
		return order;
	}

	@PostMapping( value="/order")
	public Order insertOrder(@RequestBody Order order){
		System.out.println("Post insert Order: " + order);
		order.setDatetime(LocalDateTime.now());
		orderService.save(order);
		System.out.println("Post insert after save Order: " + order);

		return order;

	}

//	@PutMapping(value="/order/{id}")
//	public Order updateOrder(@PathVariable(name="id") Integer id,@RequestBody Order order ){
//		System.out.println("Post update order");
//
//	}

//	@DeleteMapping(value="/order/{id}")
//	public String deleteOrder(@PathVariable(name="id") Integer id){
//
//
//	}
}
