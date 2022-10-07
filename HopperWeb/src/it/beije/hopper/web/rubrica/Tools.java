package it.beije.hopper.web.rubrica;

import java.util.Scanner;

public class Tools {
	
	public static int getScelta() {
		Scanner s = new Scanner(System.in);
		int scelta;

		try {
			scelta = Integer.parseInt( s.next() );
			
			if(scelta < 0) {
				System.out.println("Errore, ripetere l'operazione... PS: inserire un valore intero POSITIVO\n");
				scelta = -1;
			}
			
		}catch(NumberFormatException NFE) {
			System.out.println("Errore, ripetere l'operazione... PS: inserire un valore numerico\n");
			scelta = -1;
		}
		
		return scelta;
	}
	
	public static int getScelta(int min, int max) {
		Scanner s = new Scanner(System.in);
		int scelta;

		do {
			System.out.print("Scelta: ");
			scelta = Tools.getScelta();
		}while(scelta < min || scelta > max);
		
		return scelta;
	}
}
