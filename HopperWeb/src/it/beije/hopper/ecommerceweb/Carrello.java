package it.beije.hopper.ecommerceweb;

import java.util.ArrayList;
import java.util.List;

import it.beije.hopper.entity.Product;

public class Carrello {

	List<Product> list;
	List<Integer> unico;
	
	public Carrello() {
		list=new ArrayList<>();
		unico=new ArrayList<>();
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
