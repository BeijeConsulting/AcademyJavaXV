package it.beije.java.xv.esercizi.pile;

import java.util.Random;

import it.beije.java.xv.esercizi.Elettrodomestici.ElettroPile;

public class Telecomando extends ElettroPile {
	
	private String name;
	private boolean inserita;
	private boolean on;
	
	public boolean isInserita() {
		inserita = new Random().nextInt(2) == 1;
		return inserita;
	}

	public boolean isOn() {
		if( !isInserita() )
			return false;
		return on;
	}


	public void setName(String name) {
		this.name = name;
		
	}


	public String getName() {
		return this.name;
	}


	public void setIsOn(boolean on) {
		if( isInserita() ) 
			on = true;
		else
			on = false;
	}
	
	public int raggioAzione() {
		return new Random().nextInt(0, 21);  
	}
	
}
