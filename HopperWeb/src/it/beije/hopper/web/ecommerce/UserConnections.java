package it.beije.hopper.web.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class UserConnections {
	
	public static User login(String email, String password) {
		EntityManager entityManager = JPAEntityManager.getConnection();
		
		StringBuilder strigQuery = new StringBuilder("SELECT u FROM User as u WHERE u.email = :email AND u.password = :password");
		Query query = entityManager.createQuery( strigQuery.toString() );
		query.setParameter("email", email );
		query.setParameter("password", password);
		
		List<User> user = query.getResultList();
		
		if( user.isEmpty() ) return null;
		
		return user.get(0);
	}
	
	public static void addUser(User newUser) {
		EntityManager entityManager = JPAEntityManager.getConnection();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist( newUser );
		entityTransaction.commit();
	}
	
}
