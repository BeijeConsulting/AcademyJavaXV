package it.beije.xv.esercizi.codetestsOCA.capitolo5.classdesign.polymorphism;

public class Lemur extends Primate implements HasTail {

	@Override
	public boolean isTailStriped() {
		System.out.println("isTailStriped()");
		return false;
	}
	public int age = 10;
	
	public static void main(String[] args) {
		Lemur lemur = new Lemur();
		System.out.println(lemur.age);
		
		HasTail hasTail = lemur;
		System.out.println(hasTail.isTailStriped());
		
		Primate primate = lemur;
		System.out.println(primate.hasHair());
		
		System.out.println("--------");
		//Lemur lemur2 = new Primate(); // child cannot refer to parent
		HasTail hasTail2 = lemur;
		//System.out.println(hasTail2.age);
		System.out.println(hasTail2.isTailStriped());
		
		System.out.println(((Lemur)hasTail2).age);
		
		// -----------------
		Primate primate3 = new Lemur();
		Lemur lemur3 = (Lemur)primate3;
		HasTail hastail3 = lemur3;
		
		
	}

}
