package it.beije.hopper.spring;

import java.util.ArrayList;
import java.util.List;

import it.beije.hopper.ecommerce.model.Product;



public class Carrello {

	List<Product> list;
	
	public Carrello() {
		list=new ArrayList<>();
	}
	
	public void add(Product p) {
		list.add(p);
	}
	
	public List<Product> getProdotti() {
		return list;	
	}
	
	public int size() {
		int i;
		for(i=0;i<list.size();i++);
		return i;
	}
	
	public Product getProduct(int i) {
		return list.get(i);
	}
	
	
	
	
	
	
	
	
	
}
