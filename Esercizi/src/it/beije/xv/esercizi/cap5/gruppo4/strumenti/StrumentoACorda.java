package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public abstract class StrumentoACorda extends StrumentoMusicale{
	public boolean accordato;
	public int numeroCorde;
	
	public void suona() {
		System.out.println("Lo strumento " + this.nome 
				+ " riproduce le note tramite le corde");
	}
		
	public void getInfo() {
		super.getInfo();
		System.out.println("\tNumero di corde: " + this.numeroCorde);
		System.out.println("\tLo strumento è accordato: " + accordato);
	}
}
