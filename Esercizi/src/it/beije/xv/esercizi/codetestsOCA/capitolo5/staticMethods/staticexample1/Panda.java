package it.beije.xv.esercizi.codetestsOCA.capitolo5.staticMethods.staticexample1;

public class Panda extends Bear {
	public static void eat() {
		System.out.println("Panda bear is chewing");	
	}
	
	public static void main(String[] args) {
		Panda.eat();
		Bear.eat();
		eat();
		eatTwo();
		
	}
}
