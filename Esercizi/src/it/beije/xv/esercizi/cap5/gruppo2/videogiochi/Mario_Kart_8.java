package it.beije.xv.esercizi.cap5.gruppo2.videogiochi;

public class Mario_Kart_8 extends Sports implements Singleplayer, Multiplayer, Online, Offline {
	
	boolean multiplayer;
	boolean singleplayer;
	boolean online;
	boolean offline;
	
	public Mario_Kart_8() {
		name = "Mario Kart 8";
		year = "2017";
		rating = 8.7;
		maxNumPlayers = 4;
		multiplayer = isMultiplayer();
		singleplayer = isSingleplayer();
		online = isOnline();
		offline = isOffline();
	}
	
	public void getGameInfo() {
		System.out.println(name);
		System.out.println(year);
		System.out.println(rating);
		System.out.println("Il gioco è giocabile in modalità multiplayer: " + multiplayer );
		System.out.println("Il gioco è giocabile in modalità singleplayer: " + singleplayer );
		System.out.println("Il gioco è giocabile online: " + online );
		System.out.println("Il gioco è giocabile offline: " + offline );
		System.out.println();
	}
}