package it.beije.magazzino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.magazzino.model.Item;
import it.beije.magazzino.repository.ItemRepository;


@Service
public class ItemService {
	
	@Autowired 
	ItemRepository itemRepository;

	public List<Item> listItemByIdShipment(Integer id_shipment){
		return itemRepository.loadListByIdShipment(id_shipment);
	}
	
}
