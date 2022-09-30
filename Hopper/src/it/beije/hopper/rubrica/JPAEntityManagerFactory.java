package it.beije.hopper.rubrica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.hopper.Contatto;


public class JPAEntityManagerFactory {

	private JPAEntityManagerFactory() {}
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager openSession() {
		if(entityManagerFactory==null)
			entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		
		return entityManagerFactory.createEntityManager();
	}
	
	
}
