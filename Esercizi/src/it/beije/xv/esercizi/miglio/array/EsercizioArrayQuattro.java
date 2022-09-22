package it.beije.xv.esercizi.miglio.array;

public class EsercizioArrayQuattro {
	public static boolean isCrescente(int[] num) {
		boolean seq = true;
		int i = 0;
		while(seq && (i += 1) < num.length) if(num[i] < num[i-1]) seq = false;
		
		return seq;
	}
	
	public static void main(String... args) {
		int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 15};
		boolean ord = isCrescente(num);
		System.out.println(ord);
	}
}
