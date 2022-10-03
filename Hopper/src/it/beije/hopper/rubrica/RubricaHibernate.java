package it.beije.hopper.rubrica;

import static it.beije.hopper.rubrica.JDBCMetodi.writeCSVtoDB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



import it.beije.hopper.Contatto;

public class RubricaHibernate {
	
	static String pathFile = "C:\\Users\\caste\\OneDrive\\Desktop\\BeijeAcademy\\Rubrica\\RubricaScanner\\rubrica.csv";
	static File file = new File(pathFile);

	public static void main(String[] args) throws IOException, SQLException {

		//writeDB();
		//deleteFromDB();
		//updateContatto();
		//fromCSVtoDB();
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
		
		System.out.println("Vuoi i dati ordinati per nome (1) o per cognome (2)?");
		Scanner s = new Scanner(System.in);
		String risposta = s.nextLine();
		
		if (risposta.equals("1"))
		{
			Query<Contatto> q1 = session.createQuery("SELECT c FROM Contatto as c");
			contatti = q1.getResultList();
			for (Contatto c : contatti) 
				System.out.println(c);
		}
		if (risposta.equals("2"))
		{
			Query<Contatto> q2 = session.createQuery("SELECT c FROM Contatto as c ORDER BY c.cognome");
			contatti = q2.getResultList();
			for (Contatto c : contatti) 
				System.out.println(c);
		}
		
		
					
	}
	
	public static void search()
	{
		Session session = HBMsessionFactory.openSession();	
		Transaction transaction = session.beginTransaction();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Vuoi cercare tramite Nome(1), Cognome(2) o Note(3)?");
		String scelta = scanner.next();
		
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		
		switch (scelta)
		{
			case "1": 
				{
					System.out.println("Inserire Nome desiderato ");
					String n = scanner.next();
					for (Contatto c: contatti)
						if (n.equals(c.getNome()))
							System.out.println(c);
				}
			case "2": 
			{
				System.out.println("Inserire Cognome desiderato ");
				String n = scanner.next();
				for (Contatto c: contatti)
					if (n.equals(c.getCognome()))
						System.out.println(c);
			}
			case "3": 
			{
				System.out.println("Inserire Note desiderato ");
				String n = scanner.next();
				for (Contatto c: contatti)
					if (n.equals(c.getNote()))
						System.out.println(c);
			}
					
			
				
		}
		

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
	
	public static void fromCSVtoDB() throws IOException
	{
		Contatto contatto = null;
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String[] arr = null;
		String linea = null;
		List<String> lista = new ArrayList();
		Session session = HBMsessionFactory.openSession();	
		Transaction transaction = session.beginTransaction();
		
		
			while (bufferedReader.ready())
			{			
				String l = bufferedReader.readLine();
				lista.add(l);
			}
			
			for (int i = 0; i<lista.size(); i++)
			{
				linea = lista.get(i).toString();
				arr = linea.split(";");					//ho i 5 campi della stringa corrente
				
				contatto = new Contatto();
				contatto.setCognome(arr[0]);
				contatto.setNome(arr[1]);
				contatto.setEmail(arr[2]);
				contatto.setTelefono(arr[3]);
				contatto.setNote(arr[4]);
								
				Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
				List<Contatto> contatti = query.getResultList();
				boolean isDuplicate = false;
				for (Contatto c : contatti)
				{
					if (c.getNome().equals(arr[0]) && c.getCognome().equals(arr[1]) &&c.getEmail().equals(arr[3]) &&c.getTelefono().equals(arr[2]) &&c.getNote().equals(arr[4]))
					{
						isDuplicate = true;
						
					}
					System.out.println(isDuplicate);
				}
							
			
			
			
				if (isDuplicate == false)
				{
					session.save(contatto);	
					transaction.commit();
				}
			}
				
			
			session.close();
	
	}
	
	
	}
