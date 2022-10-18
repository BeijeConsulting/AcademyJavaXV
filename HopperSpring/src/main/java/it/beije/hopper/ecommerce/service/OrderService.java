package it.beije.hopper.ecommerce.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.ecommerce.model.Order;
import it.beije.hopper.ecommerce.repository.OrderRepository;
import it.beije.hopper.model.User;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	

	public OrderService() {
		System.out.println("creo un oggetto OrderService...");
	}
	
	public List<Order> findByUserId(Integer userId) {
		return orderRepository.findByUserId(userId);
	}

	public Order save(Order order) {
		return orderRepository.save(order);
	}
}
