package it.beije.hopper.ecommerce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;

public class GestioneECommerce {

	static User user;
	static int[][] game;
	public static final void main(String[] args)  {
		
		GestioneUser.addUser();
		//seeMenu();

	}
	
	private static void seeMenu() {

		EntityManager entityManager = JPAEntityManager.getConnection();

		int scelta = 0;

		if(user != null)System.out.println("\t\t\tUtente: " +user.getName() );
		System.out.println("---MENU E-COMMERCE---");
		System.out.println("Benvenuto sul nostro e-commerce");
		System.out.println("1)Lista prodotti");
		System.out.println("2)Cerca prodotto");
		System.out.println("3)Prodotti più venduti");



		do {
			System.out.print("Scelta: ");
			scelta = Tools.getScelta();
		}while(scelta < 1 || scelta > 10);

		switch(scelta) {
		case 1:
			seeMenuListaProdotti();
			break;

		case 2:
			seeMenuProducts();
			break;

		case 10: 
			return;
		}

	}

	private static void seeMenuUsers() {

		int scelta = 0;

		System.out.println("\n\n---Menu Gestione Utente---");
		System.out.println("Scegli l'opzione da eseguire");
		System.out.println("1)Aggiungi nuovo utente");
		System.out.println("10)Torna menu e-commerce");

		do {
			System.out.print("Scelta: ");
			scelta = Tools.getScelta();
		}while(scelta < 1 || scelta > 10);

		switch(scelta) {
		case 1:
			GestioneUser.addUser();
			break;

		case 10: 
			return;
		}

	}

	private static void seeMenuListaProdotti() {
		List<Product>  products = ProductConnections.getAllProducts();
		int scelta = -1;
		int i = 0;

		System.out.println("\n\n---Lista Prodotti---");

		for(Product product : products) {
			System.out.println(i + ")" + GestioneProduct.stampaProdotto(product) );
			i++;
		}

		System.out.println("\nVuoi acquistare qualche prodotto?");
		System.out.println("1)Si");
		System.out.println("2)No");
		System.out.println("3)Torna al menù principale");

		do {
			System.out.print("Scelta: ");
			scelta = Tools.getScelta();
		}while(scelta < 1 || scelta > 3);

		switch(scelta) {
		case 1:
			buyProducts(products);
			break;

		case 2:
			seeMenuProducts();
			break;

		case 10: 
			return;
		}

	}

	private static void seeMenuProducts() {

		int scelta = 0;

		System.out.println("\n\n---Menu Gestione Prodotti---");
		System.out.println("Scegli l'opzione da eseguire");
		System.out.println("1)Lista Prodotti");
		System.out.println("2)Inserisci nuovo prodotto");
		System.out.println("10)Torna menu e-commerce");

		do {
			System.out.print("Scelta: ");
			scelta = Tools.getScelta();
		}while(scelta < 1 || scelta > 10);

		switch(scelta) {
		case 1:
			GestioneProduct.viewAllProducts();
			break;

		case 2:
			GestioneProduct.addProduct();
			break;

		case 10: 
			return;
		}

	}

	private static void buyProducts(List<Product> products) {
		int scelta;
		int quantity;
		Cart cart = new Cart();
		
		if(user == null) user = GestioneUser.login();

		do {
			System.out.println("\nInserire il numero del prodotto da acquistare");
			do {
				System.out.print("Scelta: ");
				scelta = Tools.getScelta();
			}while(scelta < 0 || scelta > products.size()-1);
			
			do {
				System.out.print("Quantità: ");
				quantity = Tools.getScelta();
				if(  quantity > products.get(scelta).getQuantity()) System.out.println("\nQuantità inserita superiore alla quantità di merce disponibile");
			}while(quantity < 0 || quantity > products.get(scelta).getQuantity() );
			

			cart.addProduct(products.get( scelta) , quantity );
			cart.seeCart();
			//Inserire quantità prodotti
			System.out.println("Articolo inserito correttamente nel carrello");

			System.out.println("\nVuoi inserire un altro prodotto?");
			System.out.println("1)Si");
			System.out.println("2)No");
			System.out.println("3)Torna al menù e annulla l'ordine");

			do {
				System.out.print("Scelta: ");
				scelta = Tools.getScelta();
			}while(scelta < 1 || scelta > 3);
			
		}while(scelta == 1);
		
		
		user.setCart( cart );
		
		if(scelta == 3) return;
		
		System.out.println("\nRiepilogo ordine: ");
		user.getCart().seeCart();
		
		System.out.println("\nProcedere con l'acquisto");
		System.out.println("1)Si");
		System.out.println("3)Torna al menù e annulla l'ordine");
		scelta = Tools.getScelta(1, 2);
		
		if(scelta == 1) GestioneOrder.acquista(cart);
		
		
	}
	
	
}






