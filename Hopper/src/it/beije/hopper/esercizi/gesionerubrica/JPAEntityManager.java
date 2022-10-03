package it.beije.hopper.esercizi.gesionerubrica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAEntityManager {

	private static EntityManager entityManager;
	
	private JPAEntityManager() {}
	
	public static EntityManager getConnection(){
		if(entityManager == null) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		entityManager = entityManagerFactory.createEntityManager();
		}
		
		return entityManager;
	}
	
}
