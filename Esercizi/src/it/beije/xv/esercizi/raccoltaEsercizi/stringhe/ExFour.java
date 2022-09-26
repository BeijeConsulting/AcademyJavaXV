package it.beije.java.xv.esercizi.stringhe;


//Scrivere un programma Contrario che, data una stringa, la stampa al contrario. 
//Per esempio, la stringa “Viva Java!” verrà “!avaJ aviV”
public class ExFour {
	
	public void exFourv1(String string) {
		for( int i = string.length()-1; i >= 0; i-- ) System.out.print(string.charAt(i));
	}
	
	public void exFourv2(String string) {
		System.out.println(new StringBuilder(string).reverse());
	}
	public static void main(String[] args) {
		ExFour four = new ExFour();
		four.exFourv1("Viva Java!");
		System.out.println();
		four.exFourv2("Viva Java!");
	}
	
}
