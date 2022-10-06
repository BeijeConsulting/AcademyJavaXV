package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public abstract class StrumentoAFiato extends StrumentoMusicale{
	public int numeroChiavi;
	
	public void suona() {
		System.out.println("Lo strumento " + nome 
				+ " riproduce le note tramite fiato");
	}
	
	
}
