package it.beije.hopper.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.model.Order;
import it.beije.hopper.repository.OrderRepository;


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




}
