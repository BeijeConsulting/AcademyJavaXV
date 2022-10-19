package it.beije.hopper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.repository.ItemRepository;



@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	
//	public List<Item> addProduct(List<Item> products, String id, String quantity) {
//		//int p_id = Integer.valueOf(id);
//		Integer i = Integer.valueOf(id);
//		
//		//Product product = productRepository.findById(2);
//		
//		Item item = new Item();
////		item.setOrderId(2);
////		item.setProductId( product.getId() );
////		item.setName( product.getName() );
////		item.setDesc( product.getDesc() );
////		item.setPrice( product.getPrice() );
////		item.setQuantity( Integer.valueOf(quantity) );
//		
//		products.add(item);
//		
//		return products;
//	}
	
	public List<Item> loadBestSellingProducts(){
		List<Item> products = itemRepository.loadBestSellingOrderDesc();
		List<Integer> quantity = itemRepository.loadBestSellingQuantityDesc();
		
		for(int i = 0 ;  i < products.size(); i++) {
			products.get(i).setOrderId(null); //Le informazioni sul numero di ordine sono private
			products.get(i).setQuantity(quantity.get(i));
		}
	
		return products;
	}
}


