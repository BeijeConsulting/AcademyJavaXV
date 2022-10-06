package it.beije.hopper.ecommerce;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.beije.hopper.ecommerce.JPAEntityManager;

public class OrderItemsConnections {

	public static void addOrderItems(OrderItems o) {
		EntityManager entityManager = JPAEntityManager.getConnection();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist( o );
		entityTransaction.commit();
	}
}
