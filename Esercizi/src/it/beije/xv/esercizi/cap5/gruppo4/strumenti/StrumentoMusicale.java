package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public abstract class StrumentoMusicale {
	String nome;
	String dimensione;
	String materiale;
	
	public StrumentoMusicale() {
		this.nome = "Strumento musicale generico";
		this.dimensione = "N.D.";
		this.materiale = "N.D.";
	}
	
	public StrumentoMusicale(String newName, String newDim, String newMat){
		this.nome = newName;
		this.dimensione = newDim;
		this.materiale = newMat;
	}
	
	public void suona() {
		System.out.println("Lo strumento musicale suona");
	}
	
	public void getInfo() {
		System.out.println("\tNome dello strumento: " + this.nome);
		System.out.println("\tDimensioni: " + this.dimensione);
		System.out.println("\tMateriale: " + this.materiale);
	}
}
