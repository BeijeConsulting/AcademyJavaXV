package it.beije.hopper.rubrica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.beije.hopper.Contatto;
import it.beije.hopper.ecommerce.Order;


public class RubricaJPA {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Contatto contatto = null;
		
		//SELECT c FROM Contatto as c WHERE id = X
		contatto = entityManager.find(Contatto.class, 106);
		System.out.println("contatto : " + contatto);
		
//		int orderId = 1;
//		Order order = entityManager.find(Order.class, orderId);
//		Query query = entityManager.createQuery("SELECT i FROM Item as i WHERE order_id = " + orderId);//SELECT * FROM rubrica
//		order.setItems(query.getResultList());
//		System.out.println("order : " + order);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		//INSERT
		Contatto newContatto = new Contatto();
		//newContatto.setId(50);
		newContatto.setCognome("Marinelli");
		newContatto.setNome("Raffaele");
		newContatto.setEmail("r.marinelli@beije.it");
		System.out.println("contatto PRE : " + newContatto);

		entityManager.persist(newContatto);

		System.out.println("contatto POST : " + newContatto);
		
		
		//UPDATE
//		System.out.println("modifico : " + contatto);
//		//contatto.setId(20);
//		contatto.setNote("queste sono le note");
//		contatto.setNome("Piero");
//		entityManager.persist(contatto);
//		System.out.println("contatto POST update : " + contatto);
//
//		//DELETE
//		entityManager.remove(contatto);

		//SELECT JPQL
//		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM rubrica
//		List<Contatto> contatti = query.getResultList();
//		for (Contatto c : contatti) {
//			System.out.println(c);
//			if (c.getId() == 21) contatto = c;
//		}
//		System.out.println(contatti.size());

		
		//if (true) throw new RuntimeException();
		
//		entityTransaction.commit();
		//entityTransaction.rollback();

		entityManager.close();
	}

}
