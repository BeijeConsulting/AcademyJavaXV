package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public class Piano extends StrumentoACorda implements Seduto, Accordato{
	
	public Piano() {
		nome = "Piano";
		dimensione = "Grande";
	}
	public void getInfo() {
		System.out.println(nome);
		System.out.println(dimensione);
		System.out.println("Da seduto: " + daSeduto());
		System.out.println("Accordato: " + isAccordato());
		System.out.println();
	}

}
