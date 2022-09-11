package it.beije.xv.esercizi.cap5.gruppo2.videogiochi;

public class Hades extends Roguelikes implements Singleplayer, Offline {
	
	boolean singleplayer;
	boolean offline;
	
	public Hades() {
		name = "Hades";
		year = "2018";
		rating = 8.9;
		singleplayer = isSingleplayer();
		offline = isOffline();
	}
	
	public void getGameInfo() {
		System.out.println(name);
		System.out.println(year);
		System.out.println(rating);
		System.out.println("Il gioco è giocabile in modalità singleplayer: " + singleplayer );
		System.out.println("Il gioco è giocabile offline: " + offline );
		System.out.println();
	}
}