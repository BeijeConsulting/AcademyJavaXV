package it.beije.xv.esercizi.miglio.array;

public class EserciziArrayOtto {
	
	public static String[] addString(String s, String[] a) {
		String[] vettore = new String[a.length + 1];
		for(int i = 0; i < a.length; i++) vettore[i] = a[i];
		vettore[vettore.length - 1] = s;
		
		return vettore;
	}
	
	public static void main(String... args) {
		String[] a = {"Ciao", "a", "tutti", "come", "va", "fratello"};
		String s = "?";
		String[] risultato = addString(s, a);
		for(String parola:risultato) System.out.println(parola);
	}
}