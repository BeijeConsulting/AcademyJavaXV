package it.beije.hopper.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.service.ItemService;

@RequestMapping(value="item")
@RestController
public class ItemRestController {

	@Autowired ItemService itemService;
	
	@GetMapping(value="getbyid/{id}")
	public Item getById(@PathVariable(value="id")Integer id) throws Exception {
		Item item=itemService.getById(id);
		return item;
	}
}
