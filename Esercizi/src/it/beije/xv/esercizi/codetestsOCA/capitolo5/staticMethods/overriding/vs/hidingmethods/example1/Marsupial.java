package it.beije.xv.esercizi.codetestsOCA.capitolo5.staticMethods.overriding.vs.hidingmethods.example1;

public class Marsupial {
	public static boolean isBiped() {
		return false;
	}
	
	public void getMarsupialDescription() {
		System.out.println("Marsupial walks on two legs: " + isBiped());
	}
}
