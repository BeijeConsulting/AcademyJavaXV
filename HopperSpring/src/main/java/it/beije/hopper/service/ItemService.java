package it.beije.hopper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.model.Product;
import it.beije.hopper.repository.ProductRepository;
import it.beije.hopper.repository.UserRepository;


@Service
public class ItemService {

	@Autowired
	private ProductRepository productRepository;
	
	
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
	
}
