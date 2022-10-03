package it.beije.hopper.rubrica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.beije.hopper.Contatto;
import it.beije.hopper.Recapito;

public class JPAPROVA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		 Recapito recapito = null;
		 		 
//		 List<Recapito> recapiti = entityManager.createQuery("from Recapito r", Recapito.class).getResultList();
//		 for (Recapito c : recapiti)
//			 System.out.println(c);
		 
		 
		 List<Contatto> recapiti1 = entityManager.createQuery("SELECT c FROM Contatto as c Join Recapito as r ON c.id=r.rubrica_id").getResultList();
		 for (Contatto c : recapiti1)
			 System.out.println(c);
		 
		entityTransaction.commit();
		entityManager.close();
	}

}
