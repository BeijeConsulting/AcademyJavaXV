package it.beije.xv.esercizi.codetestsOCA.capitolo5.classdesign.polymorphism.polymorphicparameters;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj = new Object();
		Reptile reptile = new Reptile();
		//reptile = obj; WRONG!
		reptile = (Reptile)obj;
	}

}
