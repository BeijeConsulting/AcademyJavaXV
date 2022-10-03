package it.beije.hopper.rubrica;

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import org.hibernate.query.Query;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.beije.hopper.Contatto;

public class RubricaHBMScanner {

	public static void testHBM() {
		

		Session session = HBMsessionFactory.openSession();
		System.out.println("session is open? " + session.isOpen());
				
		Transaction transaction = session.beginTransaction();
		
		Contatto contatto = null;
		Contatto contattoD = null;
		int idsc = 0;
		
		//SCANNER
		System.out.println("Premi 'I' per inserire, 'U' per modificare, 'D' per cancellare, 'S' per vedere il db,");
		
		Scanner modifiche = new Scanner(System.in);
		String st = modifiche.next();
		
		
		
		//INSERT
		if (st.equals("I")) {
			contatto = new Contatto();
			
			System.out.println("inserisci i dati");
			Scanner insert = new Scanner(System.in);
			System.out.print("Cognome: ");
			String cognome= insert.nextLine();
			System.out.print("Nome: ");
			String nome= insert.nextLine();
			System.out.print("Telefono: ");
			String telefono= insert.nextLine();
			System.out.print("Email: ");
			String email= insert.nextLine();
			System.out.print("Note: ");
			String note= insert.nextLine();
		
			contatto.setCognome(cognome);
			contatto.setNome(nome);
			contatto.setTelefono(telefono);
			contatto.setEmail(email);
			contatto.setNote(note);
		
//		System.out.println("contatto PRE : " + contatto);
			session.save(contatto);
//		System.out.println("contatto POST : " + contatto);
		}
		
		
		
		
		
		//SE DIVERSO DA SELECT E INSERT CHIEDI ID
				if (!st.equals("S") && !st.equals("I")) {
					Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM rubrica
					List<Contatto> contatti = query.getResultList();
					for (Contatto c : contatti) {
						System.out.println(c);
					}
					System.out.println("id contatto");
					Scanner scan = new Scanner(System.in);
					int scanner= scan.nextInt();
					idsc=scanner;
					}
		
		//SELECT HQL
		
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM rubrica
		List<Contatto> contatti = query.getResultList();
		for (Contatto c : contatti) {
			if (st.equals("S") || st.equals("I") ) {
			System.out.println(c);
			}
			if (c.getId() == idsc) contatto = c;
		}
		System.out.println(contatti.size());
		

		
		
		//UPDATE
		if (st.equals("U")) {
			
		System.out.println("modifico : " + contatto);
			System.out.println("inserisci le modifiche");
			Scanner insert = new Scanner(System.in);
			System.out.print("Cognome: ");
			String cognome= insert.nextLine();
			System.out.print("Nome: ");
			String nome= insert.nextLine();
			System.out.print("Telefono: ");
			String telefono= insert.nextLine();
			System.out.print("Email: ");
			String email= insert.nextLine();
			System.out.print("Note: ");
			String note= insert.nextLine();
		contatto.setNote(note);
		contatto.setNome(nome);
		contatto.setCognome(cognome);
		contatto.setEmail(email);
		contatto.setTelefono(telefono);
		//System.out.println("contatto PRE update : " + contatto);
		session.save(contatto);
		System.out.println("contatto POST update : " + contatto);
		}
		
		
		//DELETE
		if (st.equals("D")) {
		session.remove(contatto);
		System.out.println("contatto cancellato " + contatto);
		}
		transaction.commit();
		//transaction.rollback();
		
		
		
		

		
		
		
		session.close();
		
		
		
		
	}
	
		
	
	public static void main(String[] args) {
		
		testHBM();
		
	}

}
