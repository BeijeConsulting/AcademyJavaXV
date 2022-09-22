package it.beije.xv.esercizi.miglio.array;
import java.util.Scanner;

public class EsercizioMorraCinese {
	public static String partita(String giocatore1, String giocatore2) {
		String vincitore;
		switch(giocatore1) {
			case "forbice":
				if(giocatore2.equalsIgnoreCase("sasso")) vincitore = giocatore2;
				else if(giocatore2.equalsIgnoreCase("carta")) vincitore = giocatore1;
				else vincitore = "pari";
				break;
			case "carta":
				if(giocatore2.equalsIgnoreCase("forbice")) vincitore = giocatore2;
				else if(giocatore2.equalsIgnoreCase("sasso")) vincitore = giocatore1;
				else vincitore = "pari";
				break;
			case "sasso":
				if(giocatore2.equalsIgnoreCase("carta")) vincitore = giocatore2;
				else if(giocatore2.equalsIgnoreCase("forbice")) vincitore = giocatore1;
				else vincitore = "pari";
				break;
			default: vincitore = "Non sapete giocare, DioBoia!";
			}
		return vincitore;
	}
	
	public static void main(String... args) {

		Scanner myObj = new Scanner(System.in);
		String giocatore1 = "";
		String giocatore2 = "";
				
		while(!giocatore1.equalsIgnoreCase("sasso") && !giocatore1.equalsIgnoreCase("carta") && !giocatore1.equalsIgnoreCase("forbice")) {
			System.out.print("Inserier scelta giocatore 1: ");
			giocatore1 = myObj.nextLine();
		}
		
		while(!giocatore2.equalsIgnoreCase("sasso") && !giocatore2.equalsIgnoreCase("carta") && !giocatore2.equalsIgnoreCase("forbice")) {
			System.out.print("Inserier scelta giocatore 2: ");
			giocatore2 = myObj.nextLine();
		}
		
		String vincitore = partita(giocatore1, giocatore2);
		System.out.println("Vincitore: " + vincitore);
	}
}
