package it.beije.hopper.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GestioneOrder {

	public static void acquista(Cart carrello) {
		List<Product> products;
		
		//Controlla se gli articoli inseriti sono ancora disponibili
		for(OrderItems product: carrello.getProducts()) {
			if( !GestioneOrder.isAvailable(product) ) {
				System.out.println("Attenzione... Non sono più disponibili " + product.getQuantity() + " del prodotto" + product.getName() + ". Modificare il carrello.");
				//Aggiungere modifica carrello
			}
		}
		
		//Decrementiamo numero degli articoli disponibili sul database
		for(OrderItems product : carrello.getProducts()) {
			GestioneOrder.decrementProduct(product);
		}
		
		System.out.println("Acquisto eseguito correttamente");
	}
	
	public static boolean isAvailable(OrderItems item) {
		
		Product product = ProductConnections.getProduct( item.getProduct_id() );
		
		if(product == null) return false;
		
		return (product.getQuantity() >= item.getQuantity() )  ?  true :  false;
	}
	
	public static void decrementProduct(OrderItems item) {
		
		Product product =  ProductConnections.getProduct( item.getProduct_id() );
		
		product.setQuantity( product.getQuantity() - item.getQuantity() );
		
		EntityManager entityManager = JPAEntityManager.getConnection();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist( product );
		System.out.println(product.getName() + " "+product.getQuantity());
		entityTransaction.commit();
	}
	
}
