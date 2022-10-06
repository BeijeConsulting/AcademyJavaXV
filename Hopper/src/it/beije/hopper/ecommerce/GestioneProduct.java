package it.beije.hopper.ecommerce;

import java.util.List;
import java.util.Scanner;



public class GestioneProduct {

	public static void addProduct() {

		Product product = new Product();
		Scanner s = new Scanner(System.in);
		int scelta = 0;

		System.out.println("\nInserisci informazioni del prodotto");

		System.out.print("Nome: ");
		product.setName( s.next() );

		System.out.print("Descrizione: ");
		product.setDesc( s.next() );

		System.out.print("Prezzo:");
		product.setPrice( (double) Tools.getScelta() ); //Cast da int a double

		System.out.print("Quantità: ");
		product.setQuantity( Tools.getScelta() );	//AutoCasting da int a Integer

		System.out.print("Voto: ");
		product.setRating(  Tools.getScelta() );

		System.out.println("\nRiepilogo prodotto");
		System.out.println( product.toString() );

		do {
			System.out.println("\nSalvare contatto? 1)Si	2)No");
			System.out.print("Scelta: ");
			scelta = Tools.getScelta();
		}while(scelta < 1 || scelta > 2);


		switch(scelta) {
		case 1: 
			ProductConnections.addProduct (product ); 
			System.out.println("Prodotto aggiunto con successo");
			break;

		case 2: 
			System.out.println("Operazione annullata"); 
			break;
		}
	}

	public static void viewAllProducts() {
		System.out.println("\nLista dei prodotti presenti sul DataBase");
		List<Product> products = ProductConnections.getAllProducts();
		
		for(Product product : products) System.out.println( product );
	}
	
	public static String stampaProdotto(Product product) {
		StringBuilder builder = new StringBuilder()
				.append("Nome : ").append( product.getName() )
				.append(" | Descrizione: ").append( product.getDesc() )
				.append(" | Prezzo : ").append( product.getPrice() )
				.append(" | Quantità : ").append( product.getQuantity() )
				.append(" | Valutazione : ").append( product.getRating() );
		
		return builder.toString();
	
	}
}
