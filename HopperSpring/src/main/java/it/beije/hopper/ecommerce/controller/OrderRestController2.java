package it.beije.hopper.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import it.beije.hopper.ecommerce.model.Order;
import it.beije.hopper.ecommerce.repository.OrderRepository;


@Controller
@RequestMapping(value = "api")
public class OrderRestController2 {

	public OrderRestController2() {
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

	@PostMapping(value = "/orders")
	public Order insertOrder(@RequestBody Order order) {
		System.out.println("POST insert Order : " + order);

		orderRepository.save(order);
		System.out.println("order post save : " + order);

		return order;
	}

	@PutMapping(value = "/orders/{id}")
	public Order updateOrder(@PathVariable(name = "id") Integer id, @RequestBody Order newData) {
		System.out.println("POST updateUser id : " + id + " : " + newData);

		if (id.compareTo(newData.getId()) == 0) {//OK modifico

			Optional<Order> o = orderRepository.findById(id);

			if(o.isPresent()) {
				o.get().setDatetime(newData.getDatetime());
				o.get().setAmount(newData.getAmount());
				o.get().setPromo(newData.getPromo());
				o.get().setUserId(newData.getUserId());
				o.get().setUserId(newData.getUserId());
				o.get().setItems(newData.getItems());

				BeanUtils.copyProperties(newData, o, "id");

				orderRepository.save(o.get());
				System.out.println("order with new data : " + o);

				return o.get();
			} else new IllegalArgumentException("id non corrispondenti");
		} else
			throw new IllegalArgumentException("id non corrispondenti");
		return newData;
	}

	@DeleteMapping(value = "/orders/{id}")
	public String deleteUser(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE delete order : " + id);

		orderRepository.deleteById(id);

		return "{\"message\":\"rimosso user " + id + "\"}";
	}
}
