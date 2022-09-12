package it.beije.xv.esercizi.cap5.gruppo2.videogiochi;

public class The_Last_of_Us extends Survivals implements Singleplayer, Offline {
	
	boolean multiplayer;
	boolean singleplayer;
	boolean online;
	boolean offline;
	
	public The_Last_of_Us() {
		name = "The Last of Us";
		year = "2013";
		rating = 9.7;
		maxNumPlayers = 1;
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