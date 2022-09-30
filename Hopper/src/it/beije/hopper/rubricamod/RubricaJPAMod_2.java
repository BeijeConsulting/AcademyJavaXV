package it.beije.hopper.rubricamod;

import it.beije.hopper.Contatto;
import it.beije.hopper.rubricamod.fileMod.CSVmanagerMod;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

//TODO: need to manage deletion, find and update when user is searching by id... (Name is not always present).
public class RubricaJPAMod_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while(true){
			System.out.println("Rubrica Manager (JPA):)");
			System.out.println("(1): Load data (from a file to db)\n(2): Export data (from DB to file)\n(3): CLI application\n(4): exit application");
			Integer decision = Integer.valueOf(scanner.nextLine());
			if( decision == 1 ){
				System.out.println("Load data from File to DB...");
				System.out.print("Enter file path: ");
				String path = "src/testFile_CSV_XML/rubrichecsv/rubrica - cognomeReduced.csv";
				//scanner.nextLine();
				List<Contatto> contatti = CSVmanagerMod.readRubrica(path);
				System.out.println(contatti);
				jpaSessionImport(contatti);
			}else if( decision == 2){
				System.out.println("Load data from DB to File...");
				System.out.print("Enter file path: ");
				String path = "src/testFile_CSV_XML/output/rubrica-output.csv";
				//scanner.nextLine();
				jpaSessionExportData(path);

			}else if( decision == 3){
				jpaSessionTerminalApp(scanner);
			}else{
				System.out.println("Exiting Rubrica Manager...");
				break;
			}
		}




	}

	//exports data from db to file
	public static void jpaSessionExportData(String path){
		//List<Contatto> selectJPA(EntityManager entityManager, String query)

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

//		EntityTransaction entityTransaction = entityManager.getTransaction();

		List<Contatto> contatti = selectJPA(entityManager, "SELECT e FROM Contatto e");
		try{
			CSVmanagerMod.writeRubrica(contatti, path);
		}catch(IOException ioe){
			System.out.println("Error with path " + path); //TODO
			ioe.printStackTrace();
			ioe.getMessage();
		}

		entityManager.close();
		entityManagerFactory.close();
	}

	public static void jpaSessionImport(List<Contatto> contatti) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		for( Contatto contatto: contatti){
//			System.out.println("DATA: " + contatto);
			entityManager.persist(contatto);

		}
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		return;
	}
	public static void jpaSessionTerminalApp(Scanner scanner){

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		//Contatto contatto = null;

		int decision = 99;
		System.out.println("Terminal Session starting....");
		do{

			System.out.println("Select\n(1): Insert\n(2): Delete\n(3): Find\n(4): Show all\n(5): Modify contact\n(6): Exit application");
			decision = Integer.valueOf(scanner.nextLine());
			if( decision == 1 ){
				insertNewContatto(entityManager, scanner);

			}else if( decision == 2 ){
				deleteContatto(entityManager, scanner);

			}else if( decision == 3){
				findContatto(entityManager,scanner);

			}else if( decision == 4){
				showAllContatto( entityManager, scanner);

				//modify
			}else if( decision == 5){
				updateJPA(entityManager,  scanner);

			}else if(decision == 6){
				break;
			}else{
				System.out.println("Option not available.");

			}
		}while( decision != 6);


	}


	///FILE --> DB utility
	//takes an arrayList and transfers the data to DB
	public static void insertContattiFile(List<Contatto> contatti, EntityManager entityManager){
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		for( Contatto contatto: contatti){
			entityManager.persist(contatto);
		}

		entityTransaction.commit();
		//entityTransaction.rollback();
		return;
	}


	/// CLI methods ///////////////////////////////////
	//inserisci nuovo contatto ()
	public static void insertNewContatto(EntityManager entityManager, Scanner scanner){

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Contatto newContatto = new Contatto();

		System.out.println("Entering new contact....");
		System.out.print("Name: ");
		newContatto.setNome(scanner.nextLine());
		System.out.print("Last name: ");
		newContatto.setCognome(scanner.nextLine());
		System.out.print("Phone number: ");
		newContatto.setTelefono(scanner.nextLine());
		System.out.print("Email: ");
		newContatto.setEmail(scanner.nextLine());

		System.out.printf("Adding new contact: " + newContatto.getNome() + " " + newContatto.getCognome());
		entityManager.persist(newContatto);
		System.out.printf("Confirm? ('yes' or 'no')");

		if( scanner.nextLine().equalsIgnoreCase("yes")){
			entityTransaction.commit();
			System.out.println(newContatto.getNome() + " " + newContatto.getCognome() +" added.");
		}else{
			entityTransaction.rollback();
			System.out.println("Insertion cancelled.");
		}



	}

	//cancella contatto()
	public static void deleteContatto(EntityManager entityManager, Scanner scanner){
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		System.out.println("(Delete) Search by 'name' or 'last name'?");
		String findData = scanner.nextLine();
		System.out.print("Enter " + findData + ": ");
		findData = scanner.nextLine();
		Contatto contatto = selectJPASpecific(entityManager, "SELECT e FROM Contatto e", findData);

		entityManager.remove(contatto);
		System.out.println("Are you sre you want to delete " + contatto +"? ('yes' or 'no')");
		if( scanner.nextLine().equalsIgnoreCase("yes")){
			entityTransaction.commit();
			System.out.println("Deletion completed");
		}else{
			entityTransaction.rollback();
			System.out.println("Deletion cancelled");
		}

	}

	//cerca contatto ()
	//trova contatti duplicati e uniscili()
	public static void findContatto(EntityManager entityManager, Scanner scanner){

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		System.out.println("Search by 'name' or 'last name'?");
		String find = scanner.nextLine();
		if( find.equalsIgnoreCase("name")){
			find = "nome";
		}else if( find.equalsIgnoreCase("last name")){
			find="cognome";
		}
		System.out.print("Enter " + find +": ");
		String data = scanner.nextLine();
		System.out.println("SELECT e FROM Contatto e WHERE "+find+"="+data);
		List<Contatto> contatti = selectJPA(entityManager, "SELECT e FROM Contatto e WHERE "+find+"='"+data+"'" );
		if(contatti.size()>1){
			System.out.println("Duplicates found.\nDo you want fix the duplicates?");
			if( scanner.nextLine().equalsIgnoreCase("yes")){
				System.out.println("These are the duplicates..");
				for( Contatto contatto: contatti ){
					System.out.println("Contatto: " + contatto);

				}
				System.out.println("If you only want to keep one enter 'yes'");
				Contatto c = null;
				if( scanner.nextLine().trim().equalsIgnoreCase("yes")){
					System.out.print("Enter id of value you want to keep: ");
					//SELECT c FROM Contatto as c WHERE id = X
					c = entityManager.find(Contatto.class, Integer.valueOf(scanner.nextLine()));
					System.out.println("Deleting duplicates...");
					for( Contatto contatto: contatti){
						if( contatto.getId() != c.getId()){
							entityManager.remove(contatto);
						}
					}
					entityTransaction.commit();

				} ///TODO add else... merge let user select which parts of the duplicates to keep
			}
			contatti = selectJPA(entityManager, "SELECT e FROM Contatto e WHERE "+find+"='"+data+"'" );
		}
		System.out.println("Contacts...");
		for( Contatto contatto: contatti ){
			System.out.println("Contatto:" + contatto);
		}




	}

	/////////////////////////
	//vedi lista contatti (con possibilità di ordinare per nome e cognome a scelta)
	public static void showAllContatto(EntityManager entityManager, Scanner scanner){
		System.out.print("Order by 'name' or 'last name'? ");
		String orderBy = scanner.nextLine();
		if( orderBy.equalsIgnoreCase("name")){
			orderBy = "nome";
		}else if( orderBy.equalsIgnoreCase("last name") ){
			orderBy="cognome";
		}

		List<Contatto> contatti = selectJPA(entityManager, "SELECT e FROM Contatto e ORDER BY "+orderBy+" ASC" );
		for( Contatto contatto: contatti){
			System.out.println("contatto: " + contatto);
		}
	}


	//modifica contatto
	public static void updateJPA(EntityManager entityManager, Scanner scanner){
		String query ="SELECT e FROM Contatto e";//TODO modify
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		System.out.print("Modify name or last name?(commands: 'name' /  'last name') ");
		String criteria = scanner.nextLine();
		System.out.print("You selected (" + criteria + ")\nEnter " + criteria + " to be modified: ");
		String modifyData = scanner.nextLine();

		//extract Contatto based on criteria
		Contatto contatto = selectJPASpecific( entityManager, query, modifyData );

		System.out.println("Modifying " + contatto.getNome() + " "
				+ contatto.getCognome() + " with id:" + contatto.getId() );
		System.out.print("New " + criteria +": ");
		String newData = scanner.nextLine();

		updateJPAutil(contatto, criteria, modifyData, newData);
		System.out.print("You modified " + contatto.getNome() +" "+ contatto.getCognome()+" to "+ newData+" do you want to confirm modification? ('yes' or 'no') ");
		if( scanner.nextLine().equalsIgnoreCase("yes")){
			entityTransaction.commit();
			System.out.println("Updated.");

		}else{
			System.out.println("Cancelling...");
			entityTransaction.rollback();
		}

	}


	//contatto --> contatto to modify, criteria=(name, lastname), modifyData--> newData.
	private static void updateJPAutil(Contatto contatto, String criteria, String modifyData, String newData){
		if( criteria.equalsIgnoreCase("name") && contatto.getNome().equalsIgnoreCase(modifyData)){
			contatto.setNome(newData);
		}else if(criteria.equalsIgnoreCase("last name") && contatto.getCognome().equalsIgnoreCase(modifyData)){
			contatto.setCognome(newData);
		}
		return;
	}

	public static Contatto selectJPASpecific(EntityManager entityManager, String query, String findData){
		List<Contatto> contatti = selectJPA(entityManager,query );
		Contatto contatto = null;
		for( Contatto c : contatti ){
			if( c.getNome().equalsIgnoreCase(findData) || c.getCognome().equalsIgnoreCase(findData) ){
				contatto = c;
				break;
			}
		}
		return contatto;
	}


	public static List<Contatto> selectJPA(EntityManager entityManager, String query){
		List<Contatto> contatti = entityManager.createQuery(query).getResultList();
		//System.out.println(contatti);
		return contatti;
	}

}
