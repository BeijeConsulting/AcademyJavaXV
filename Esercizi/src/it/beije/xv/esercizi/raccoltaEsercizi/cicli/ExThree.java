package it.beije.java.xv.esercizi.cicli;

//Scrivere un programma che stampi le tabellina del numero dato come argomento
public class ExThree {
	public void exThree(int number) {
		System.out.println("Tabellina di " + number);
		for( int i = 0; i <= 10; i++ ) {
			System.out.print(String.format("[%02d] ", i*number));
		}
		System.out.println();
	}
}
