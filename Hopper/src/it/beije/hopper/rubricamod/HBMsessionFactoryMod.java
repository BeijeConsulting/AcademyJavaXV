package it.beije.hopper.rubricamod;

import it.beije.hopper.Contatto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HBMsessionFactoryMod {

	private HBMsessionFactoryMod() {}
	
	private static SessionFactory sessionFactory;
	
	public static Session openSession() {
		if (sessionFactory == null) {
			System.out.println("creo SessionFactory...");
			
			Configuration configuration = new Configuration().configure()
					.addAnnotatedClass(Contatto.class);

			sessionFactory = configuration.buildSessionFactory();
		}
		
		return sessionFactory.openSession();
	}

}
