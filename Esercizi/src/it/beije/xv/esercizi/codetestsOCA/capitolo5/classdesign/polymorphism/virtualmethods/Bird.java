package it.beije.xv.esercizi.codetestsOCA.capitolo5.classdesign.polymorphism.virtualmethods;

public class Bird {
	public String getName() {
		System.out.println("getName() Class Bird");
		return "Unknown";
	}
	public void displayInformation() {
		System.out.println("displayInformation() class Bird");
		System.out.println("The bird name is:" + getName());
	}
}
