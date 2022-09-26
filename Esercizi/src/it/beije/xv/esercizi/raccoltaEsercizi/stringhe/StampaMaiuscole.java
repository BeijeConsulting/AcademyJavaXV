package it.beije.java.xv.esercizi.stringhe;
// Scrivere un programma StampaMaiuscole che,
// dato un array di stringhe, ne stampa 
// solo quelle con la prima lettera maiuscola
public class StampaMaiuscole {

	public void exTwo(String[] strings) {
		for( String string : strings ) {
			if( firstCapital( string )) System.out.println(string);
		}
	}
	
	private boolean firstCapital(String str) {
		if( str != null && Character.isUpperCase(str.charAt(0))  ) {
			return true;
		}
		return false;
	}	
	
	
	public static void main(String[] args) {
		StampaMaiuscole two = new StampaMaiuscole();
		//String[] strings =  {"Giovanni", "luca", "Francesco", "izmark"};
		//two.exTwo(strings );
		
		
		two.exTwo( new String[] {"Giovanni", "luca", "Francesco", "izmark", "Davide"} );
	}
}
