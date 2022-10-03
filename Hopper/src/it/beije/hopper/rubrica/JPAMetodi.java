package it.beije.hopper.rubrica;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mysql.cj.Query;

import it.beije.hopper.Contatto;
import it.beije.hopper.Recapito;

public class JPAMetodi {
	 

	public static void main(String[] args) {
		
		
		
//		insertJPA();
		readJPA();
//		updateJPA();
//		deleteJPA();
		
		
	}
	
	public static void readJPA()
	{
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		 Contatto contatto = null;
		 Recapito recapito = null;
		 
		 
		 List<Contatto> contatti = entityManager.createQuery("from Contatto c", Contatto.class).getResultList();
		 for (Contatto c : contatti)
			 System.out.println(c);
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public static void insertJPA()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Contatto newContatto = new Contatto();
		 
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Inserire Nome: ");		
		newContatto.setNome(scanner.nextLine());
		
		System.out.println("Inserire Cognome: ");
		newContatto.setCognome(scanner.nextLine());
		
		System.out.println("Inserire Telefono: ");
		newContatto.setTelefono(scanner.nextLine());
		
		System.out.println("Inserire Email: ");
		newContatto.setEmail(scanner.nextLine());
		
		System.out.println("Inserire Note: ");
		newContatto.setNote(scanner.nextLine());
		
		entityManager.persist(newContatto);
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public static void updateJPA()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Inserire ID del contatto che vuoi aggiornare: ");		
		int id =Integer.parseInt(scanner.nextLine());
		System.out.println("Inserire Nome: ");		
		String nome = scanner.nextLine();
		
		System.out.println("Inserire Cognome: ");
		String cognome = scanner.nextLine();
		
		System.out.println("Inserire Telefono: ");
		String telefono = scanner.nextLine();
		
		System.out.println("Inserire Email: ");
		String email = scanner.nextLine();
		
		System.out.println("Inserire Note: ");
		String note = scanner.nextLine();
		
		
		Contatto newContatto = new Contatto();
				
		List<Contatto> contatti = entityManager.createQuery("from Contatto e", Contatto.class).getResultList();
		for (Contatto c : contatti) {
			if (c.getId() == id)
			{
				c.setNome(nome);
				c.setCognome(cognome);
				c.setEmail(email);
				c.setNote(note);
				c.setTelefono(telefono);
				entityManager.persist(newContatto);
			}
		}
			
		entityTransaction.commit();
		entityManager.close();
	}
	
	public static void deleteJPA()
	{
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Contatto contatto = new Contatto();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserire ID del contatto che vuoi eliminare: ");		
		int id =Integer.parseInt(scanner.nextLine());	
		
		List<Contatto> contatti = entityManager.createQuery("from Contatto e", Contatto.class).getResultList();
		for (Contatto c : contatti) {
			if (c.getId() == id)
			{
				entityManager.remove(c);
			}
		}
	
		entityTransaction.commit();
		entityManager.close();
	}

}
