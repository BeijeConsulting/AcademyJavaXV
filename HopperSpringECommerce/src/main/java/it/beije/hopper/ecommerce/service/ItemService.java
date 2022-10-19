package it.beije.hopper.ecommerce.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.model.Order;
import it.beije.hopper.ecommerce.repository.ItemRepository;
import it.beije.hopper.spring.Carrello;

@Service
public class ItemService {

	@Autowired ItemRepository itemRepository;
	
	public Item getById(Integer id) throws Exception {
		Optional<Item> item=itemRepository.findById(id);
		if(!item.isPresent())
			throw new Exception();
		return item.get();
	}
	
	public void insert(Item item) {
		itemRepository.save(item);	
	}
	
	public void orderItem(Order order,Carrello product) {
		
		Item item;
		LOOP:for(int i=0;i<product.size();i++) {
			if(i!=0)
				for(int j=i-1;j>=0;j--) {
					
					if(product.getProduct(i).getId()==product.getProduct(j).getId()) {
						Item items=itemRepository.findByName(order.getId()+""+product.getProduct(i).getId());
						items.setQuantity(items.getQuantity()+1);
						items.setPrice(items.getPrice()+product.getProduct(i).getPrice());
						itemRepository.save(items);
						continue LOOP;
					}					
				}
			
			item=new Item();
			item.setOrderId(order.getId());
			item.setProductId(product.getProduct(i).getId());
			item.setName(order.getId()+""+product.getProduct(i).getId());
			item.setPrice(product.getProduct(i).getPrice());
			item.setDesc(product.getProduct(i).getDesc());
			item.setQuantity(1);
			itemRepository.save(item);
		}
		
	}
}
