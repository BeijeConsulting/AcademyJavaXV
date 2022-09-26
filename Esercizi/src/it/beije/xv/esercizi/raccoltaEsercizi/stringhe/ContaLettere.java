package it.beije.java.xv.esercizi.stringhe;

/*
 Scrivere il metodo
 public int contaLettera(char c, String str)
 che conta le occorrenze della lettera c nella stringa str
 */

public class ContaLettere {
	
	public int contaLettera(char c, String str) {
		int counter = 0;
		for( int i = 0; i < str.length(); i++ ) {
			if( Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(c)) {
				counter++;
			}
		}
		return counter;
	}
	
	public static void main(String[] args) {
		
		ContaLettere three = new ContaLettere();
		System.out.println(three.contaLettera('a', "Aaa1A2\312") );
		
	}
}
