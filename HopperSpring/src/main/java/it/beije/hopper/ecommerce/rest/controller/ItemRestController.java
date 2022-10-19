package it.beije.hopper.ecommerce.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.service.ItemService;



@RestController
@RequestMapping(value = "api")
public class ItemRestController {

	@Autowired
	ItemService itemService;
	
	@GetMapping(value = "/best_selling_products")
	public List<Item> best_selling_products() {
		return itemService.loadBestSellingProducts();
	}
}