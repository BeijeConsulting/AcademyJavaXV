package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public class Violoncello extends StrumentoACorda implements HasFiddleStick, Accordato, Seduto{
	boolean fiddleStick;

	public Violoncello() {
		nome = "Violoncello";
		dimensione = "Grande";
		this.fiddleStick = hasStick();
	}
	
	public void suona() {
		System.out.println("Lo strumento " + this.nome 
				+ " riproduce le note tramite l' archetto e le corde");
	}
	
	public void getInfo() {
		System.out.println(nome);
		System.out.println(dimensione);
		System.out.println("Archetto: " + this.fiddleStick);
		System.out.println("Accordato: " + isAccordato());
		System.out.println("Seduto: " + daSeduto());
		System.out.println();
	}
	

}
