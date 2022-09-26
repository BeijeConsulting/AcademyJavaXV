package it.beije.java.xv.esercizi.stringhe;

//Scrivere un programma SoloVocali che, 
// data una stringa, ne stampa le sole vocali

public class SoloVocali {
	
	public void soloVocali(String string) {
		//StringBuilder newString = new StringBuilder(string);
		String vocals = "aeiouAEIOU";
		for( int i = 0; i < string.length(); i++) {
			//If charac. at index i is not a string then --> -1
			if( vocals.indexOf(string.charAt(i)) != -1) {
				System.out.println(string.charAt(i));
			}
		}
	}
	
	public static void main(String[] args) {
		SoloVocali one = new SoloVocali();
		one.soloVocali("Babba LyseaIagA");
	}
}
