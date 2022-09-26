package it.beije.xv.esercizi.raccoltaEsercizi.cicli;

public class ExFour {
	
	public void exFour(int val) {
		for( int i = 0; i<val; i++) {
			for( int j = 0; j < val - i; j++) System.out.print("*");
			System.out.println();
		}
	}
}
