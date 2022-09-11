package it.beije.xv.esercizi.cap5.gruppo2.videogiochi;

public class Super_Mario_Odyssey extends Action_Adventure implements Singleplayer, Multiplayer, Offline {
	
	boolean multiplayer;
	boolean singleplayer;
	boolean offline;
	
	public Super_Mario_Odyssey() {
		name = "Super Mario Odyssey";
		year = "2017";
		rating = 9.1;
		multiplayer = isMultiplayer();
		singleplayer = isSingleplayer();
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