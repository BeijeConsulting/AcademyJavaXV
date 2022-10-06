package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public class Chitarra extends StrumentoACorda implements Accordato, Amplificazione {
	
	boolean accordato;
	boolean amplificazione;
	
	public Chitarra() {
		numeroCorde = 6;
		nome = "Chitarra";
		dimensione = "Media";
		materiale = "Legno";
		accordato = isAccordato();
		amplificazione = hasAmplification();
		
	}
	public void getInfo() {
		super.getInfo();
		System.out.println("\tPuò essere amplificato: " + amplificazione);
		System.out.println();
	}

}
