package it.beije.hopper.web.rubrica;

public class GestioneOrderItems {

	public static String stampaProdotto(OrderItems product) {
		//String s = "Nome: " + product.getName() + " | Descrizione: " + product.getDesc() + " | Prezzo: " + product.getPrice() + " | Quantity: " + product.getQuantity() + " | Valutazione: " + product.getRating();
		
		StringBuilder builder = new StringBuilder()
				.append("Nome : ").append( product.getName() )
				.append(" | Descrizione: ").append( product.getDesc() )
				.append(" | Prezzo : ").append( product.getPrice() )
				.append(" | Quantità : ").append( product.getQuantity() )
				.append(" | Promo : ").append( product.getPromo() );
		
		return builder.toString();
	
	}
	
}
