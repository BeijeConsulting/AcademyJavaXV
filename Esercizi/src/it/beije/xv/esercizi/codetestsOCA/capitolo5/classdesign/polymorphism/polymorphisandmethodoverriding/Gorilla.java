package it.beije.xv.esercizi.codetestsOCA.capitolo5.classdesign.polymorphism.polymorphisandmethodoverriding;

public class Gorilla extends Animal {
	protected String getName() {
		System.out.println("class Gorilla extends Animal getName()");
		return "Gorilla";
	}
}
