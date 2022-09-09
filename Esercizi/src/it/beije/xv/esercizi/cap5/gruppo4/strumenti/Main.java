package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public class Main {
	public static void main (String[] args) {
		Chitarra chitarra = new Chitarra();
		chitarra.suona();
		Violino violino = new Violino();
		Piano piano = new Piano();
		violino.suona();
		violino.getInfo();
		chitarra.getInfo();
		piano.getInfo();
		piano.suona();
	}

}
