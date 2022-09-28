package it.beije.hopper.rubricamod;

import it.beije.hopper.Contatto;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;


public class RubricaJPAMod {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		jpaSession(scanner);

	}


	public static void jpaSession(Scanner scanner){

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		//Contatto contatto = null;


//		insertNewContatto(entityManager, scanner);
//		deleteContatto(entityManager, scanner);
		findContatto(entityManager,scanner);
		//showAllContatto(entityManager, scanner);

		//modifica contatto
		//updateJPA(entityManager, "tobemodified",  scanner);



//
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();

		//INSERT
//		Contatto newContatto = new Contatto();
//		//newContatto.setId(50);
//		newContatto.setCognome("Marinelli");
//		newContatto.setNome("Raffaele");
//		newContatto.setEmail("r.marinelli@beije.it");
//		System.out.println("contatto PRE : " + newContatto);
//
//		entityManager.persist(newContatto);
//
//		System.out.println("contatto POST : " + newContatto);


		//UPDATE
//		System.out.println("modifico : " + contatto);
//		//contatto.setId(20);
//		contatto.setNote("queste sono le note");
//		contatto.setNome("Piero");
//		entityManager.persist(contatto);
//		System.out.println("contatto POST update : " + contatto);

//		//DELETE
//		entityManager.remove(contatto);


//
//		List<Contatto> contatti = selectJPA(entityManager, "SELECT e FROM Contatto e");
//
//
//
//		entityTransaction.commit();
//		//entityTransaction.rollback();
//
		entityManager.close();
	}


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
		System.out.println("Enter " + findData + ": ");
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
		System.out.println("Order by 'name' or 'last name'?");
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

	/////////////////////////
	//modifica contatto
	public static void updateJPA(EntityManager entityManager,String query, Scanner scanner){
		query ="SELECT e FROM Contatto e";//TODO modify
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
		System.out.println("You modified " + contatto.getNome() +" "+ contatto.getCognome()+" to "+ newData+" do you want to confirm modification? ('yes' or 'no')");
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
