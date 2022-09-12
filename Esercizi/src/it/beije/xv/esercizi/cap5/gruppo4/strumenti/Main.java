package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public class Main {
	public static void main (String[] args) {
		Chitarra chitarra = new Chitarra();
		Violino violino = new Violino();
		Piano piano = new Piano();
		Batteria batteria = new Batteria();
		
		chitarra.suona();
		chitarra.getInfo();
		
		violino.suona();
		violino.getInfo();
		
		piano.suona();
		piano.getInfo();
		
		batteria.suona();
		batteria.getInfo();
		
		

	}

}
