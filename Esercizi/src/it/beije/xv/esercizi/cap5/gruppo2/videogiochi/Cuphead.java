package it.beije.xv.esercizi.cap5.gruppo2.videogiochi;

public class Cuphead extends Platform implements Singleplayer, Multiplayer, Offline {
	
	boolean singleplayer;
	boolean multiplayer;
	boolean offline;
	
	public Cuphead() {
		name = "Cuphead";
		year = "2017";
		rating = 8.7;
		maxNumPlayers = 2;
		singleplayer = isSingleplayer();
		multiplayer = isMultiplayer();
		offline = isOffline();
	}
	
	public void getGameInfo() {
		System.out.println(name);
		System.out.println(year);
		System.out.println(rating);
		System.out.println("Il gioco è giocabile in modalità multiplayer: " + multiplayer );
		System.out.println("Il gioco è giocabile in modalità singleplayer: " + singleplayer );
		System.out.println("Il gioco è giocabile offline: " + offline );
		System.out.println();
	}
}