package it.beije.hopper.ecommerce;

import java.util.Scanner;

public class GestioneUser {

	public static void addUser() {
		
		User newUser = new User();
		Scanner s = new Scanner(System.in);
		int scelta = 0;

		System.out.println("\nInserisci informazioni dell'utente");

		System.out.print("Email: ");
		newUser.setEmail( s.next() );

		System.out.print("Password: ");
		newUser.setPassword( s.next() );

		System.out.print("Nome:");
		newUser.setName( s.next() );

		System.out.print("Cognome: ");
		newUser.setSurname( s.next() );

		System.out.println("\nRiepilogo contatto");
		System.out.println( newUser );
		
		do {
			System.out.println("\nSalvare contatto? 1)Si	2)No");
			System.out.print("Scelta: ");
			scelta = Tools.getScelta();
		}while(scelta < 1 || scelta > 2);
		
		
		switch(scelta) {
		case 1: 
			UserConnections.addUser (newUser ); 
			System.out.println("Utente aggiunto con successo");
			break;
		
		case 2: 
			System.out.println("Operazione annullata"); 
			break;
		}
	}
	
//	public static User login() {
//		
//		User newUser = new User();
//		Scanner s = new Scanner(System.in);
//		int scelta = 0;
//		
//		String email;
//		String password;
//		
//		System.out.println("\n---Login---");
//		
//		System.out.print("Email: ");
//		email = s.next();
//		
//		System.out.print("Password: ");
//		password = s.next();
//		
//		User user = UserConnections.login(email, password);
//		
//		return user;
//	}
	
	 static private void login() {

	        EntityManager entityManager=JPAEntityManagerFactory.openSession();
	        EntityTransaction transaction=entityManager.getTransaction();

	        transaction.begin();

	        Scanner scanner = new Scanner(System.in);
	        String email;
	        String password;

	        System.out.println("Benvenuto, inserire email e password:");
	        System.out.print("Email: ");
	        email=scanner.nextLine();
	        System.out.print("Password: ");
	        password=scanner.nextLine();

	        Query query=entityManager.createQuery("SELECT u FROM User AS u WHERE u.email='"+email+"' AND u.password='"+password+"'");
	        User user=(User)query.getResultList().get(0);
	        if(user!=null) {
	            System.out.println("Login avvenuto con successo!");
	            System.out.println("Per effettuare un ordine digita 1, altrimenti digita 0");
	            if(scanner.nextLine().equalsIgnoreCase("1"))
	                order(user.getId());
	        }
	    }
	
}
