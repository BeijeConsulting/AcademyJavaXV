package it.beije.xv.esercizi.codetestsOCA.capitolo5.interfaces.example1;

public class LeopardSeal extends HarboarSeal {

	@Override
	public int getTailLength() {
		
		return 10;
	}

	@Override
	public int getNumberOfWhiskers() {
		return 100;
	}
	
	public static void main(String[] args) {
		LeopardSeal karen = new LeopardSeal();
		
		System.out.println(karen.getTailLength());
		System.out.println(karen.getTailLength());
	}

}
