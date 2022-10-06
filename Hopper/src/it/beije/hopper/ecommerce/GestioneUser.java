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
	
	public static User login() {
		
		User newUser = new User();
		Scanner s = new Scanner(System.in);
		int scelta = 0;
		
		String email;
		String password;
		
		System.out.println("\n---Login---");
		
		System.out.print("Email: ");
		email = s.next();
		
		System.out.print("Password: ");
		password = s.next();
		
		User user = UserConnections.login(email, password);
		
		return user;
	}
	
}
