package it.beije.xv.esercizi.codetestsOCA.capitolo5.classdesign.polymorphism.virtualmethods;

public class Peacock extends Bird {
	
	@Override
	public String getName() {
		System.out.println("getName() class Peacock extends Bird");
		return "Peacock";
	}
	
	
	public static void main(String[] args) {
		Bird bird = new Peacock();
		bird.displayInformation(); //display information is called from bird, getName() is called from Peacock
		(new Bird()).displayInformation();
		
		
	}
}
