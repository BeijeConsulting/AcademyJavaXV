package it.beije.xv.esercizi.miglio.array;

public class EsercizioArrayTre {
	
	public static boolean contains(int elemento, int[] num) {
		boolean risultato = false;
		
		for(int i = 0; i < num.length; i++) {
			if(elemento == num[i]) risultato = true;
		}
		
		return risultato;
	}
	
	public static void main(String args[]) {
		int[] num = {3, 3, 4, 5, 1, 43, 10, 90, 36, 71};
		int elemento = 10;
		
		boolean ricerca = contains(elemento, num);
		System.out.println(ricerca);
	}
}
