package it.beije.hopper.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.model.Order;
import it.beije.hopper.ecommerce.model.Product;
import it.beije.hopper.model.User;
import it.beije.hopper.repository.ItemRepository;
import it.beije.hopper.repository.ProductRepository;
import it.beije.hopper.repository.UserRepository;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	public ItemService() {
		System.out.println("creo un oggetto ItemService...");
	}
	
	public List<Item> deleteByOrderId(Integer orderId) {
		return itemRepository.deleteByOrderId(orderId);
	}
	
	public Item save(Item item) {
		return itemRepository.save(item);
	}
	}


