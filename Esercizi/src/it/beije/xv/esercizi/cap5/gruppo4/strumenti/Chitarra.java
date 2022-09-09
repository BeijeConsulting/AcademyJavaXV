package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public class Chitarra extends StrumentoACorda implements Accordato {
	
	boolean accordato;
	
	public Chitarra() {
		numeroCorde = 6;
		nome = "Chitarra";
		dimensione = "Media";
		accordato = isAccordato();
	}
	public void getInfo() {
		System.out.println(nome);
		System.out.println(dimensione);
		System.out.println("Accordato: " + accordato );
		System.out.println();
	}
}
