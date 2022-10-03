package it.beije.hopper.esercizi.gesionerubrica;

import it.beije.hopper.Contatto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class GestioneConnessioniJPA {

	//Gestione Rubrica con JPA
		
		protected static List<Contatto> getAllContacts() throws ClassNotFoundException, SQLException {
			EntityManager entityManager = JPAEntityManager.getConnection();
			Query query = entityManager.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM rubrica
			List<Contatto> contatti = query.getResultList();
			return contatti;
		}
		
		protected static void saveContact(Contatto newContatto) {
			EntityManager entityManager = JPAEntityManager.getConnection();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(newContatto);
			entityTransaction.commit();
		}
		
		protected static Contatto searchContactsFromID(int id) {
			
			if(id < 0) return null;
			
			StringBuilder strigQuery = new StringBuilder("SELECT c FROM Contatto as c WHERE c.id = :id");
			
			EntityManager entityManager = JPAEntityManager.getConnection();
			Query query = entityManager.createQuery( strigQuery.toString() );

			//Set dei parametri query
			query.setParameter("id", id );

			List<Contatto> contatti = query.getResultList();

			return contatti.get(0);		
		}
		
		protected static List<Contatto> searchContacts(Contatto contatto) {
		
			if( contatto.isEmpy() ) return new ArrayList<Contatto>();

			StringBuilder strigQuery = new StringBuilder("SELECT c FROM Contatto as c ");
			boolean firstParameter = true;
			strigQuery.append("WHERE ");

			
			if( contatto.getCognome() != null ) {
				firstParameter = false;
				strigQuery.append("c.cognome = :cognome");
			}

			if( contatto.getNome() != null  ) {
				if( firstParameter == false ) strigQuery.append(" AND ");
				else firstParameter = false;
				strigQuery.append("c.nome = :nome");
			}

			if( contatto.getTelefono() != null ) {
				if( firstParameter == false ) strigQuery.append(" AND ");
				else firstParameter = false;
				strigQuery.append("c.telefono = :telefono");
			}

			if( contatto.getEmail() != null ) {
				if( firstParameter == false ) strigQuery.append(" AND ");
				else firstParameter = false;
				strigQuery.append("c.email = :email");
			}

			if( contatto.getNote() != null ) {
				if( firstParameter == false ) strigQuery.append(" AND ");
				else firstParameter = false;
				strigQuery.append("c.note = :note");
			}

			EntityManager entityManager = JPAEntityManager.getConnection();
			Query query = entityManager.createQuery( strigQuery.toString() );

			//Set dei parametri query
			if(contatto.getCognome() != null ) query.setParameter("cognome", contatto.getCognome() );
			if(contatto.getNome() != null ) query.setParameter("nome", contatto.getNome() );
			if(contatto.getTelefono() != null ) query.setParameter("telefono", contatto.getTelefono() );
			if(contatto.getEmail() != null ) query.setParameter("email", contatto.getEmail() );
			if(contatto.getNote() != null ) query.setParameter("note", contatto.getNote() );

			List<Contatto> contatti = query.getResultList();

			return contatti;		
		}
		
		protected static void editContact(Contatto contatto) {
			EntityManager entityManager = JPAEntityManager.getConnection();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(contatto);
			System.out.println(contatto.getNome());
			entityTransaction.commit();
		}

//		protected static boolean editContact(Contatto contatto) {
//			
//			Contatto oldContact = searchContactsFromID(contatto.getId());
//			if( contatto.getCognome().equals( oldContact.getCognome() ) ) contatto.setCognome(null);
//			if( contatto.getNome().equals( oldContact.getNome() ) ) contatto.setNome(null);
//			if( contatto.getTelefono().equals( oldContact.getTelefono() ) ) contatto.setTelefono(null);
//			if( contatto.getEmail().equals( oldContact.getEmail() ) ) contatto.setEmail(null);
//			if( contatto.getNote().equals( oldContact.getNote() ) ) contatto.setNote(null);
//			
//			
//			if( contatto.isEmpy() ) return false;
//			
//			StringBuilder strigQuery = new StringBuilder("UPDATE rubrica r SET ");
//			boolean firstParameter = true;
//
//			
//			if( contatto.getCognome() != null ) {
//				firstParameter = false;
//				strigQuery.append("c.cognome = :cognome");
//			}
//
//			if( contatto.getNome() != null  ) {
//				if( firstParameter == false ) strigQuery.append(" , ");
//				else firstParameter = false;
//				strigQuery.append("c.nome = :nome");
//			}
//
//			if( contatto.getTelefono() != null ) {
//				if( firstParameter == false ) strigQuery.append(" , ");
//				else firstParameter = false;
//				strigQuery.append("c.telefono = :telefono");
//			}
//
//			if( contatto.getEmail() != null ) {
//				if( firstParameter == false ) strigQuery.append(" , ");
//				else firstParameter = false;
//				strigQuery.append("c.email = :email");
//			}
//
//			if( contatto.getNote() != null ) {
//				if( firstParameter == false ) strigQuery.append(" , ");
//				else firstParameter = false;
//				strigQuery.append("c.note = :note");
//			}
//
//			strigQuery.append(" WHERE r.id = :id");
//			EntityManager entityManager = JPAEntityManager.getConnection();
//			Query query = entityManager.createQuery( strigQuery.toString() );
//
//			//Set dei parametri query
//			if(contatto.getCognome() != null ) query.setParameter("cognome", contatto.getCognome() );
//			if(contatto.getNome() != null ) query.setParameter("nome", contatto.getNome() );
//			if(contatto.getTelefono() != null ) query.setParameter("telefono", contatto.getTelefono() );
//			if(contatto.getEmail() != null ) query.setParameter("email", contatto.getEmail() );
//			if(contatto.getNote() != null ) query.setParameter("note", contatto.getNote() );
//			query.setParameter("id", contatto.getId());
//			
//			query.executeUpdate();
//
//			//List<Contatto> contatti = query.getResultList();
//
//			return true;
//		}
//		
//		
}
