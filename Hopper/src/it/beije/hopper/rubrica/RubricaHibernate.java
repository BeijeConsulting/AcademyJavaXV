package it.beije.hopper.rubrica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import it.beije.hopper.Contatto;

public class RubricaHibernate {
	
	static String pathFile = "C:\\Users\\caste\\OneDrive\\Desktop\\BeijeAcademy\\Rubrica\\RubricaScanner\\rubrica.csv";
	static File file = new File(pathFile);

	public static void main(String[] args) {

		//writeDB();
		//deleteFromDB();
		//updateContatto();
	}
	
	
	public static void writeDB()
	{
		boolean isFound = false; 
		Session session = HBMsessionFactory.openSession();	
		Transaction transaction = session.beginTransaction();
		Contatto contatto = null;
		Scanner scanner = new Scanner(System.in);
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
		//INSERT
		contatto = new Contatto();
		contatto.setCognome(cognome);
		contatto.setNome(nome);
		contatto.setEmail(email);
		contatto.setTelefono(telefono);
		contatto.setNote(note);
		
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM rubrica
		//Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE cognome = 'Bianchi'");
		List<Contatto> contatti = query.getResultList();
		for (Contatto c : contatti) {
			if (cognome.equals(c.getCognome())&& nome.equals(c.getNome())&&email.equals(c.getEmail())&&telefono.equals(c.getTelefono())&&note.equals(c.getNote()))
			{
				isFound = true;
			}
		}
		if (isFound == false)
		{
			session.save(contatto);
			transaction.commit();
		}
		
		
		session.close();
	}
	
	public static void deleteFromDB()
	{
		Session session = HBMsessionFactory.openSession();	
		Transaction transaction = session.beginTransaction();
		Contatto contatto = new Contatto();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserire ID del contatto che vuoi eliminare: ");		
		int id =Integer.parseInt(scanner.nextLine());				
		contatto.setId(id);
		session.remove(contatto);
		transaction.commit();
		session.close();
	}
	
	public static void updateContatto()
	{
		Session session = HBMsessionFactory.openSession();	
		Transaction transaction = session.beginTransaction();
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
		
		
		Contatto contatto = new Contatto();
				
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM rubrica
		//Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE cognome = 'Bianchi'");
		List<Contatto> contatti = query.getResultList();
		for (Contatto c : contatti) {
			System.out.println(c);
			if (c.getId() == id)
			{
				c.setNome(nome);
				c.setCognome(cognome);
				c.setEmail(email);
				c.setNote(note);
				c.setTelefono(telefono);
				session.save(c);
			}
		}
		transaction.commit();
		session.close();
	
	}	
	
	public static void readDB() {
		Session session = HBMsessionFactory.openSession();	
		Transaction transaction = session.beginTransaction();
		Contatto contatto = new Contatto();
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		//Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE cognome = 'Bianchi'");
		List<Contatto> contatti = query.getResultList();
		for (Contatto c : contatti) 
			System.out.println(c);
					
	}
	
	public static void searchID()
	{
		Session session = HBMsessionFactory.openSession();	
		Transaction transaction = session.beginTransaction();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserire ID del contatto cercato: ");		
		int id =Integer.parseInt(scanner.nextLine());
		
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		for (Contatto c : contatti)
			if(id == c.getId())
				System.out.println(c);
	}
	
	public static void toCSV() throws IOException								//schifosino
	{
		FileWriter fileWriter = new FileWriter(file);
		Session session = HBMsessionFactory.openSession();	
		Transaction transaction = session.beginTransaction();

		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		for (Contatto c : contatti)
		{
			fileWriter.write(c.getCognome()+";" + c.getNome()+";" +c.getTelefono()+";" +c.getEmail()+";" +c.getNote()+"\n");
		}
		fileWriter.flush();
			
	}
	
	}
