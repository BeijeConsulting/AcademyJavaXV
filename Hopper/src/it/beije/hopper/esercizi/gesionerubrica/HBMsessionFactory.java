package it.beije.hopper.esercizi.gesionerubrica;

import it.beije.hopper.Contatto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HBMsessionFactory {

	private HBMsessionFactory() {}
	
	private static SessionFactory sessionFactory;
	
	public static Session opernSession() {
		if(sessionFactory == null ) {
			System.out.println("creo SessionFactory");
			
			Configuration configuration = new Configuration().configure()
					.addAnnotatedClass(Contatto.class);
			
			sessionFactory = configuration.buildSessionFactory();
		}
		
		return sessionFactory.openSession();
	}
}
