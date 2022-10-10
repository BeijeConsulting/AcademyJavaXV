package it.beije.hopper.ecommerceweb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class JPAEntityManagerFactory {

	private JPAEntityManagerFactory() {}
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager openSession() {
		if(entityManagerFactory==null)
			entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		
		return entityManagerFactory.createEntityManager();
	}
	
	
}
