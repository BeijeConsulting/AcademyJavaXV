package it.beije.java.xv.esercizi.stringhe;

import java.util.Scanner;


//Scrivere un programma Concatena che chiede all’utente 
// di inserire tre singole parole e le ristampa interponendovi un
// asterisco. Per esempio, se l’utente inserisce
// “gatto”, “cane” e “topo” il programma stamperà “gatto*cane*topo”.

public class Concatena {
	private Scanner scanner;
	
	public Concatena(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void concatena() {
		System.out.println("Three words: ");
		//String userIn = scanner.nextLine();
		StringBuilder builder = new StringBuilder();
		int i = 2;
		while( i-- > 0 ) {
			builder.append(scanner.nextLine() + "*");
		}
		builder.append(scanner.nextLine());
		System.out.println(builder.toString());
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Concatena concatena = new Concatena(scanner);
		concatena.concatena();
		
	}
	
}
