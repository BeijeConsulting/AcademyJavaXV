package it.beije.hopper.rubricamod;

import it.beije.hopper.Contatto;
import it.beije.hopper.rubrica.HBMsessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;
import java.util.Scanner;

public class RubricaHBMMod {

	public static void testHBM(Scanner scanner) {


		Session session = HBMsessionFactory.openSession();
		System.out.println("session is open? " + session.isOpen());

//		Transaction transaction = session.getTransaction();
//		transaction.begin();
		//Transaction transaction = session.beginTransaction(); //not needed for select?
		
		Contatto contatto = null;
		
//		//INSERT
//		contatto = new Contatto();
//		contatto.setCognome("Delle Serre");
//		contatto.setNome("Emanuele");
//		contatto.setEmail("e.delleserre@beije.it");
//		contatto.setTelefono("3232490832409823");
//		contatto.setNote("Questo e' una nota!");
//
//
//		System.out.println("contatto PRE : " + contatto);
//		session.save(contatto);
//		System.out.println("contatto POST : " + contatto);

		//SELECT HQL
		//Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM rubrica
//		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE cognome = 'Bianchi'");
//		List<Contatto> contatti = query.getResultList();
//		for (Contatto c : contatti) {
//			System.out.println(c);
//			if (c.getId() == 98) contatto = c;
//		}
//		System.out.println(contatti.size());


//		//INSERT HQL CLI
//		String userIn = null;
//		while(true){
//			System.out.println("Continue data insertion?");
//			userIn = scanner.nextLine();
//			if(!userIn.equalsIgnoreCase("yes")) break;
//			insertToDB(session, scanner);
//		}
//
//
//		//SELECT HQL CLI
//		List<Contatto> contatti = selectFromDB(session, scanner );
//		//System.out.println(contatti);
//		for( Contatto c : contatti ){
//			System.out.println(c);
//		}


		//Update HQL CLI
		updateDB(session, scanner);

		//UPDATE
//		System.out.println("modifico : " + contatto);
//// 	contatto.setId(40);
//		contatto.setNote("queste sono le note");
//		contatto.setNome("Piero");
//		System.out.println("contatto PRE update : " + contatto);
//		session.save(contatto);
//		System.out.println("contatto POST update : " + contatto);

		//DELETE
//		session.remove(contatto);

//		transaction.commit();
		//transaction.rollback();
		
		session.close();
		
	}


	//CLI
	//UPDATE
	public static void updateDB(Session session, Scanner scanner){
		Transaction transaction = session.beginTransaction();
		List<Contatto> contatti = readDB("SELECT c FROM Contatto as c", session);
		Contatto contatto = null;
		FROMBEG: while( true ){
			System.out.println("Search by 'name' or 'last name'?('exit' to exit program)");
			String usrIn = scanner.nextLine();
			String dataIn = null;

			if(usrIn.equalsIgnoreCase("exit")){
				break;
			}else if( usrIn.equalsIgnoreCase("name")){
				System.out.println("Name: ");
				dataIn = scanner.nextLine();
			}else if( usrIn.equalsIgnoreCase("last name") ){
				System.out.println("Last name: ");
				dataIn = scanner.nextLine();
			}


			for( Contatto c : contatti ){
				if( dataIn.equalsIgnoreCase("")){
					System.out.println("Empty input..");
					continue FROMBEG;
				}
				if( (usrIn.equalsIgnoreCase("name") &&
						c.getNome().equalsIgnoreCase(dataIn)) ||
						(usrIn.equalsIgnoreCase("last name") &&
						c.getCognome().equalsIgnoreCase(dataIn) ) ){
					contatto = c;
					break;
				}
			}



			System.out.println("You are modifying " + contatto.getNome()+ "\nContinue?(yes / no)");
			if( scanner.nextLine().equalsIgnoreCase("yes")){
				System.out.println("Modify 'name', 'last name', 'phone', 'email', 'notes' ?");
				usrIn = scanner.nextLine();

				//TODO improve--> too many repeating code segm...
				if( usrIn.equalsIgnoreCase("name")){
					usrIn = scanner.nextLine();
					if( usrIn.length()==0 ){
						System.out.println("Empty name field...");
						continue;
					}
					contatto.setNome(usrIn);
				}else if( usrIn.equalsIgnoreCase("last name")){
					usrIn = scanner.nextLine();
					if( usrIn.length()==0 ){
						System.out.println("Empty last name field...");
						continue;
					}
					contatto.setCognome(usrIn);
				}else if( usrIn.equalsIgnoreCase("email")){
					usrIn = scanner.nextLine();
					if( usrIn.length()==0 ){
						System.out.println("Empty email field...");
						continue;
					}
					contatto.setEmail(usrIn);
				}else if( usrIn.equalsIgnoreCase("notes")){
					usrIn = scanner.nextLine(); // Fix --> multiple line input
					if( usrIn.length()==0 ){
						System.out.println("Empty notes field...");
						continue;
					}
					contatto.setNote(usrIn);

				}else{
					System.out.println("Invalid input for modification of " + contatto.getNome() + " : " + contatto.getId());
				}

				session.save(contatto);
				System.out.println("Confirm modifications on "  + contatto.getNome() + " : " + contatto.getId() + "? ('yes' or 'no')");
				if( scanner.nextLine().equalsIgnoreCase("yes")){
					transaction.commit();
					System.out.println(contatto.getNome() + ":" + contatto.getId()+ "Modified.");
				}else{
					transaction.rollback();
					System.out.println("Modification cancelled.");
				}
			}else{
				System.out.println("Modification cancelled");
			}




		}
	}




	//CLI
	//Insert HQL
	public static void insertToDB(Session session, Scanner scanner ){

		Transaction transaction = session.getTransaction();
		transaction.begin();
		//StringBuilder partialQuery
		Contatto contatto = new Contatto();
		System.out.print("Name: ");
		contatto.setNome(scanner.nextLine());
		System.out.print("Cognome: ");
		contatto.setCognome(scanner.nextLine());
		System.out.println("Email: ");
		contatto.setEmail(scanner.nextLine());
		System.out.println("Telefono:" );
		contatto.setTelefono(scanner.nextLine());
		System.out.println("Note: ");
		contatto.setNote(scanner.nextLine());

		session.save(contatto);
		System.out.println("You current inserted contatto: " + "Name: " + contatto.getNome() + "\nLast name: " + contatto.getCognome());
		System.out.println("Confirm input? ('yes' or 'no')");
		if( scanner.nextLine().equalsIgnoreCase("yes")){
			transaction.commit();
			System.out.println("Saved.");
		}else{
			transaction.rollback();
			System.out.println("Cancelled");
		}

		return;
	}




	private static List<Contatto> readDB(String finalQuery, Session session){
		Query<Contatto> query = session.createQuery(finalQuery);
		return query.getResultList();
	}


	//CLI
	//Select HQL
	public static List<Contatto> selectFromDB(Session session, Scanner scanner){
		StringBuilder partialQuery = new StringBuilder("SELECT c FROM Contatto as c");
		String finalQuery = "";
		System.out.println("Do you want all the table's contents? yes or no");
		if( scanner.nextLine().charAt(0) == 'n'){
			System.out.println("Search by 'name' or 'last name'?");
			String userin = scanner.nextLine();
			if( userin.equalsIgnoreCase(("name"))){
				System.out.print("name: ");
				partialQuery.append(" WHERE nome='"+scanner.nextLine()+"'");
			}else if( userin.equalsIgnoreCase(("last name")) ){
				System.out.printf("last name: ");
				partialQuery.append(" WHERE cognome='"+scanner.nextLine()+"'");
			}else{
				System.out.println("Unable to search with that criteria.");
				return null;
			}

		}else{
			finalQuery = partialQuery.toString();
		}
		return readDB(finalQuery, session);

	}



	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("update, select or delete?");

		testHBM(scanner);
//		testHBM();
	}

}
