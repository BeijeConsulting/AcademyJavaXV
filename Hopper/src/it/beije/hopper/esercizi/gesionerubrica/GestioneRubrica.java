package it.beije.hopper.esercizi.gesionerubrica;

import it.beije.hopper.Contatto;

public class GestioneRubrica {
	

	public static void main(String[] args) throws Exception {
		//Rubrica rubrica = new Rubrica();
		//rubrica.seeMenu();
		
		Contatto c = GestioneConnessioniJPA.searchContactsFromID(1);
		System.out.println(c.getCognome());
		String s = c.getCognome();
		if(c.getCognome().equals("Marinelli")) System.out.println("Sono ugali");
		
		System.out.println(c.getNome());
		c.setNome("Giulio");
		System.out.println(c.getNome());
		GestioneConnessioniJPA.editContact(c);
	}
	
	//Vedere query per l'aggiornamento del contattto
}
