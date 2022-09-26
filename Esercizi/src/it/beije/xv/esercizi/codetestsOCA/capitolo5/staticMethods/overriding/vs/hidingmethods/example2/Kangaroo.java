package it.beije.xv.esercizi.codetestsOCA.capitolo5.staticMethods.overriding.vs.hidingmethods.example2;

public class Kangaroo extends Marsupial {
	public boolean isBiped() {
		return true;
	}
	
	public void getKangarooDescription() {
		System.out.println("Kangaroo hops on two legs: " + isBiped());
	}
	
	public static void main(String[] args) {
		Kangaroo joey = new Kangaroo();
		joey.getMarsupialDescription(); //false
		joey.getKangarooDescription(); //true
		
		Marsupial mars = new Kangaroo();
		
		mars.getMarsupialDescription(); //false
		//mars.getKangarooDescription(); 
		
	}
}
