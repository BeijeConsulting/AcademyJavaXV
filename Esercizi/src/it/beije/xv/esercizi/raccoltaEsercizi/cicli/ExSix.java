package it.beije.java.xv.esercizi.cicli;


/**
 6 Stampare a video la seguente figura:
1      654321
12      54321
123      4321
1234      321
12345      21
123456      1

1|654321
12|54321
123|4321
1234|321
12345|21
123456|1
 * */

public class ExSix {
	
	public void exSix(int val) {
		for( int i = 0; i<val; i++ ) {
			for( int j1 = 0; j1 <=i; j1++ ) System.out.print(j1+1);
			for( int j = 0; j < val; j++) System.out.print(" ");
			for( int j2 = 0; j2 < val-i; j2++ ) System.out.print(val-j2-i);
			System.out.println();
		}
	}
	

	
}
