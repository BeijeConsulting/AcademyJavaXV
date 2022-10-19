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

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.model.Order;
import it.beije.hopper.ecommerce.repository.ItemRepository;
import it.beije.hopper.ecommerce.service.ItemService;
import it.beije.hopper.model.User;
import it.beije.hopper.repository.UserRepository;
import it.beije.hopper.service.UserService;

@RestController
@RequestMapping(value = "api")
public class ItemRestController {
	
	@Autowired
	public ItemService itemService;
	
	@Autowired
	public ItemRepository itemRepository;
	
	public ItemRestController() {
		System.out.println("creo un oggetto ItemRestController");
	}
	
	@GetMapping(value="/items")
	public List<Item> orders() {
		
		List<Item> items = itemRepository.findAll();
		
		return items;
	}
	
	@PostMapping(value = "/insertitem")
	public Item insertItem(@RequestBody Item item) {
		System.out.println("POST insertItem : " + item);
		
		itemService.save(item);
		System.out.println("item post save : " + item);
		
		return item;
	}
	
	@PutMapping(value = "/items/{id}")
	public Item updateOrder(@PathVariable(name = "id") Integer id, @RequestBody Item newData) {
		System.out.println("POST updateItemr id : " + id + " : " + newData);
		
		if (id.compareTo(newData.getId()) == 0) {//OK modifico
			
			Item item = itemService.findById(id);
			
			
			BeanUtils.copyProperties(newData, item, "id");
			
			itemService.save(item);
			System.out.println("user with new data : " + item);

			return item;
		} else
			throw new IllegalArgumentException("id non corrispondenti");
	}
	
	@DeleteMapping(value = "/items/{id}")
	public String deleteItem(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE deleteItem : " + id);
		
		itemRepository.deleteById(id);
		
		return "{\"message\":\"rimosso item " + id + "\"}";
	}

}
