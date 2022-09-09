package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public abstract class StrumentoMusicale {
	String nome;
	String dimensione;
	String materiale;

	public void suona() {
		System.out.println("Lo strumento musicale suona");
	}
	public abstract void getInfo();
}

