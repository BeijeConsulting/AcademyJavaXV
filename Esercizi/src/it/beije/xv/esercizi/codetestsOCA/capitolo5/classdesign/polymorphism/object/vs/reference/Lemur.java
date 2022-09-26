package it.beije.xv.esercizi.codetestsOCA.capitolo5.classdesign.polymorphism.object.vs.reference;

public class Lemur extends Primate implements HasTail {

	@Override
	public boolean isTailStriped() {
		return false;
	}
	
	public int age = 10;
	public static void main(String[] args) {
		Lemur lemur = new Lemur();
		System.out.println(lemur.age);
		
		HasTail hasTail = lemur;
		System.out.println(hasTail.isTailStriped());
		
		Primate primate = lemur;
		Lemur lemur2 = (Lemur)primate;
		
		Primate primate2 = new Primate();
		Lemur lemur3 = (Lemur)primate2;
		
	}

}
