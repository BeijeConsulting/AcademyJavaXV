package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public class Piano extends StrumentoACorda implements Seduto, Accordato{
	
	boolean siSuonaSeduto;
	boolean siAccorda;
	
	public Piano() {
		nome = "Piano";
		dimensione = "Grande";
		this.siSuonaSeduto = daSeduto();
		this.siAccorda = isAccordato();
	}
	
	public void suona() {
		System.out.println("Lo strumento " + nome 
				+ " riproduce le note tramite i martelletti che colpiscono le corde");
	}
	
	public void getInfo() {
		System.out.println("\tNome dello strumento: " + this.nome);
		System.out.println("\tDimensioni: " + this.dimensione);
		System.out.println("\tMateriale: " + this.materiale);
		System.out.println("\tLo strumento è accordato: " + accordato);
		System.out.println("\tDa seduto: " + daSeduto());
		System.out.println();
	}

}
