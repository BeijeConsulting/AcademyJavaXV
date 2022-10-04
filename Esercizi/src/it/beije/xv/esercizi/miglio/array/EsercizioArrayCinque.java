package it.beije.xv.esercizi.miglio.array;

public class EsercizioArrayCinque {
	public static int mostRecurrent(int[] array) {
		int occorrenze = 0;
		int numero = 0;
		
		for(int i = 0; i < array.length; i++) {
			int ricorrenze = 0;
			for(int j = 0; j < array.length; j++) {
				if(array[i] == array[j]) ricorrenze++;
			}
			if(ricorrenze > occorrenze) {
				occorrenze = ricorrenze;
				numero = array[i];
			}
		}
		
		return numero;
	}
	
	public static void main(String... args) {
		
		int[] array = {1, 4, 3, 2, 4, 3, 4, 7, 9, 3, 4, 6, 5, 2, 0, 8, 9};
		int risultato = mostRecurrent(array);
		System.out.println(risultato);
	}
}
