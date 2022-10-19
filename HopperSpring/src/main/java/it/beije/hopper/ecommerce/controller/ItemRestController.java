package it.beije.hopper.ecommerce.controller;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.repository.ItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = "api")
public class ItemRestController {

	public ItemRestController() {
		System.out.println("creo un oggetto ItemController");
	}

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping(value="/items")
	public String items(Model model) {
		
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		
		return "lista_ordini";		
	}

	@PostMapping(value = "/items")
	public Item insertItem(@RequestBody Item item) {
		System.out.println("POST insert Item : " + item);

		itemRepository.save(item);
		System.out.println("item post save : " + item);

		return item;
	}

	@PutMapping(value = "/items/{id}")
	public Item updateItem(@PathVariable(name = "id") Integer id, @RequestBody Item newData) {
		System.out.println("POST updateUser id : " + id + " : " + newData);

		if (id.compareTo(newData.getId()) == 0) {//OK modifico

			Optional<Item> o = itemRepository.findById(id);

			if(o.isPresent()) {
				o.get().setDesc(newData.getDesc());
				o.get().setName(newData.getName());
				o.get().setPromo(newData.getPromo());
				o.get().setPrice(newData.getPrice());
				o.get().setOrderId(newData.getOrderId());
				o.get().setQuantity(newData.getQuantity());

				BeanUtils.copyProperties(newData, o, "id");

				itemRepository.save(o.get());
				System.out.println("item with new data : " + o);

				return o.get();
			} else new IllegalArgumentException("id non corrispondenti");
		} else
			throw new IllegalArgumentException("id non corrispondenti");
		return newData;
	}

	@DeleteMapping(value = "/items/{id}")
	public String deleteUser(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE delete item : " + id);

		itemRepository.deleteById(id);

		return "{\"message\":\"rimosso user " + id + "\"}";
	}
}
