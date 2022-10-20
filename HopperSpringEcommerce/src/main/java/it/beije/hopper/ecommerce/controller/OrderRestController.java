package it.beije.hopper.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import it.beije.hopper.ecommerce.service.OrderService;
import it.beije.hopper.repository.ItemRepository;
import it.beije.hopper.repository.ProductRepository;
import it.beije.hopper.service.ItemService;
import it.beije.hopper.service.ProductService;


@RestController
@RequestMapping(value = "api")
public class OrderRestController {

	public OrderRestController() {
		System.out.println("creo un oggetto OrderRestController");
	}
	@Autowired
	public OrderService orderService;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	public ItemService itemService;
	@Autowired
	public ItemRepository itemRepository;
	

	@GetMapping(value="/orders")
	public List<Order> orders() {
		
		List<Order> orders = orderRepository.findAll();
		
		return orders;
	}
	@GetMapping(value="/item")
	public List<Item> items() {
		
		List<Item> items = itemRepository.findAll();
		
		return items;
	}
	
	@GetMapping(value = "/orders/{id}")
	public List<Order> getUser(@PathVariable(name = "id") Integer id) {
		System.out.println("GET getUser : " + id);
		
		List<Order> order = orderService.findByUserId(id);
		System.out.println("product : " + order);
		
		return order;
	}
	
	
	@PostMapping(value = "/add_order")
	public Order insertOrder(@RequestBody Order order, Item item) {
		System.out.println("POST insertProduct : " + order);
		
		orderService.save(order);
		System.out.println("product post save : " + order);
		
		return order;
	}
	
	
	@PostMapping(value = "/add_item")
	public Item insertItem(@RequestBody Item item) {
		System.out.println("POST insertProduct : " + item);
		
		itemService.save(item);
		System.out.println("product post save : " + item);
		
		return item;
	}
	
	@DeleteMapping(value = "/orders/{id}")
	public String deleteUser(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE deleteOrder : " + id);
		
		orderRepository.deleteById(id);
		
		return "{\"message\":\"rimosso order " + id + "\"}";
	}
}
