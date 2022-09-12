package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public class Batteria extends StrumentoAPercussione implements ConBacchette, Seduto, Amplificazione{
	

	int numeroTamburi;
	boolean amplificazione;
	

	
	public Batteria() {
		numeroTamburi = 3;
		nome = "Batteria";
		dimensione = "Grande";
		materiale = "Legno e metallo";
		amplificazione = hasAmplification();
	}
	
	public void suona() {
		System.out.println("La batteria riproduce suoni colpendo i tamburi e i piatti");
	}
	
	public void getInfo() {
		super.getInfo();
		System.out.println("\tNumero di tamburi:" + numeroTamburi);
		usaBacchette();

		
	}
	

}
