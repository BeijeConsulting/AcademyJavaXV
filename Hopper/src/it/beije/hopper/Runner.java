package it.beije.hopper;

import it.beije.hopper.rubrica.RubricaJDBC;

public class Runner {

	public static void main(String[] args) {
		
//		Singleton s = Singleton.getInstance();
//		System.out.println(s + " - " + s.risorsa--);
//		s =  Singleton.getInstance();
//		System.out.println(s + " - " + s.risorsa--);
//		s =  Singleton.getInstance();
//		System.out.println(s + " - " + s.risorsa--);
		
		int n = 0;
		while (n++ <= 151) {
			System.out.print(n + " - ");
			RubricaJDBC.main(new String[0]);
		}
	}
}
