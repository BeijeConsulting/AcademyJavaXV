package it.beije.hopper.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.model.Order;
import it.beije.hopper.ecommerce.repository.ItemRepository;
import it.beije.hopper.model.User;
import it.beije.hopper.repository.UserRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	public Item save(Item item) {
		return itemRepository.save(item);
	}

	public Item findById(Integer id) {
		Optional<Item> u = itemRepository.findById(id);
		
		if (!u.isPresent()) throw new IllegalArgumentException("Item non trovato con id " + id);

		return u.get();
	}

}
