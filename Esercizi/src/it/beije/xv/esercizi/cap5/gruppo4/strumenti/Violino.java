package it.beije.xv.esercizi.cap5.gruppo4.strumenti;


public class Violino extends StrumentoACorda implements HasFiddleStick, Accordato{
	
	boolean fiddleStick;
	
	public  Violino() {
		nome = "Violino";
		dimensione = "Medio-piccolo";
		materiale = "Acero";
		numeroCorde = 4;
		this.fiddleStick = hasStick();
	}
	
	public void suona() {
		System.out.println("Lo strumento " + this.nome 
				+ " riproduce le note tramite l' archetto e le corde");
	}
	
	public void getInfo() {
		super.getInfo();
		System.out.println("\tArchetto: " + this.fiddleStick);
		System.out.println();
	}
	

}
