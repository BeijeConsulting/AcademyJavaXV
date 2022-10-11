package it.beije.xv.esercizi.cap5.gruppo2.videogiochi;

public class Pokemon_GO extends Action_Adventure implements Singleplayer, Multiplayer, Online, Mobile {
	
	boolean multiplayer;
	boolean singleplayer;
	boolean online;
	boolean mobile;
	
	public Pokemon_GO() {
		name = "Pokemon GO";
		year = "2016";
		rating = 6.5;
		maxNumPlayers = 3;
		multiplayer = isMultiplayer();
		singleplayer = isSingleplayer();
		online = isOnline();
		mobile = isMobile();
	}
	
	public void getGameInfo() {
		System.out.println(name);
		System.out.println(year);
		System.out.println(rating);
		System.out.println("Il gioco è giocabile in modalità multiplayer: " + multiplayer );
		System.out.println("Il gioco è giocabile in modalità singleplayer: " + singleplayer );
		System.out.println("Il gioco è giocabile online: " + online );
		System.out.println("Il gioco è giocabile solo in versione mobile: " + mobile );
		System.out.println();
	}
}