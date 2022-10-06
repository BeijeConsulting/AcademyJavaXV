package it.beije.hopper.ecommerce;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;



public class ProductConnections {

	public static void addProduct(Product newProduct) {
		EntityManager entityManager = JPAEntityManager.getConnection();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist( newProduct );
		entityTransaction.commit();
	}
	
	protected static List<Product> getAllProducts(){
		EntityManager entityManager = JPAEntityManager.getConnection();
		Query query = entityManager.createQuery("SELECT p FROM Product as p");//SELECT * FROM prodotti
		List<Product> prodotti = query.getResultList();
		return prodotti;
	}
	
	protected static Product getProduct(int id){
		EntityManager entityManager = JPAEntityManager.getConnection();
		Query query = entityManager.createQuery("SELECT p FROM Product as p WHERE id = :id");//SELECT * FROM prodotti
		query.setParameter("id", id);
		List<Product> prodotti = query.getResultList();
		
		if(prodotti.isEmpty()) return null;
		
		return prodotti.get(0);
	}
	
}
