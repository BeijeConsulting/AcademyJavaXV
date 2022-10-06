package it.beije.hopper.ecommerce;

import java.util.List;
import java.util.ArrayList;

public class Cart {

	private List<OrderItems> products = new ArrayList<>();

	public List<OrderItems> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		
		List<OrderItems> appoggio = new ArrayList<>();
		
		for(Product product : products) {
			OrderItems items = new OrderItems();
			
			items.setName( product.getName() );
			items.setDesc( product.getDesc() );
			items.setPrice( product.getPrice() );
			items.setQuantity( product.getQuantity() );
			
			appoggio.add(items);
		}
		
		this.products = appoggio;
	}
	
	public  void addProduct(OrderItems product) {
		this.products.add( product );
	}
	
	public void addProduct(Product product, int quantity) {
		OrderItems items = new OrderItems();
		items.setProduct_id( product.getId() );
		items.setName( product.getName() );
		items.setDesc( product.getDesc() );
		items.setPrice( product.getPrice() );
		items.setQuantity( quantity );
		
		addProduct(items);
	}
	
	public void seeCart() {
		if(products.isEmpty())System.out.println("\nCarrello vuoto\n");
		for(OrderItems product : products) System.out.println( "- " + GestioneOrderItems.stampaProdotto(product) );
	}
	
}
