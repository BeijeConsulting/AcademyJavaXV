package it.beije.java.xv.esercizi.cicli;

public class ExTwo {
	
	public void exTwo() {
		for( int i = 20, counter = 10; counter > 0;  i--) {
			if( i%2 == 0) {
				System.out.println(i);
				counter--;
			};
		}
	}
	
}
