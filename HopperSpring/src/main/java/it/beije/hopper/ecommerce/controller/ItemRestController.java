package it.beije.hopper.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping(value="/listitems")
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

}
