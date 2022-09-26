package it.beije.xv.esercizi.raccoltaEsercizi.cicli;

public class ExFive {
	
	
	public void exFive(int val) {
		for( int i = 1; i <= val; i++ ) {
			for( int j = 0; j < i; j++  ) System.out.print("#");
			System.out.println();
		}
	}
}
