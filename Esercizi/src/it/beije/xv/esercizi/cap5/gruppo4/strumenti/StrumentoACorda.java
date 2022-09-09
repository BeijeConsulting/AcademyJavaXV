package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public abstract class StrumentoACorda extends StrumentoMusicale{
	public boolean accordato;
	public int numeroCorde;
	
	public void suona() {
		System.out.println("Lo strumento " + nome 
				+ " riproduce le note tramite le corde");
	}
	
	
}
