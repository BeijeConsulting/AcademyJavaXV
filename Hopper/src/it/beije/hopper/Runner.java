package it.beije.hopper;

import it.beije.hopper.rubrica.RubricaJDBC;

import java.sql.SQLException;

public class Runner {

	public static void main(String[] args) throws SQLException {
		
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
