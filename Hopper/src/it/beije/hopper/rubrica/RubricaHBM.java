package it.beije.hopper.rubrica;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.beije.hopper.Contatto;

public class RubricaHBM {

	public static void testHBM() {
		
//		Configuration configuration = new Configuration().configure()
//				.addAnnotatedClass(Contatto.class);
////.addAnnotatedClass(AltraClasse.class)				
//		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = HBMsessionFactory.openSession();
		System.out.println("session is open? " + session.isOpen());
				
//		Transaction transaction = session.getTransaction();
//		transaction.begin();
		Transaction transaction = session.beginTransaction();
		
		Contatto contatto = null;
		
		//INSERT
//		contatto = new Contatto();
//		contatto.setCognome("Delle Serre");
//		contatto.setNome("Emanuele");
//		contatto.setEmail("e.delleserre@beije.it");
//		
//		System.out.println("contatto PRE : " + contatto);
//		session.save(contatto);
//		System.out.println("contatto POST : " + contatto);

		//SELECT HQL
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM rubrica
		//Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE cognome = 'Bianchi'");
		List<Contatto> contatti = query.getResultList();
		for (Contatto c : contatti) {
			System.out.println(c);
			if (c.getId() == 21) contatto = c;
		}
		System.out.println(contatti.size());
		
		
		//UPDATE
//		System.out.println("modifico : " + contatto);
//		contatto.setId(40);
//		contatto.setNote("queste sono le note");
//		contatto.setNome("Piero");
//		System.out.println("contatto PRE update : " + contatto);
//		session.save(contatto);
//		System.out.println("contatto POST update : " + contatto);

		//DELETE
//		session.remove(contatto);

		transaction.commit();
		//transaction.rollback();
		
		session.close();
		
	}
	
	public static void main(String[] args) {
		
		testHBM();
		testHBM();
	}

}
