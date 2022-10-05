package it.beije.xv.esercizi.cap5.gruppo1;

import java.util.Random;

import it.beije.xv.esercizi.cap5.gruppo1.ElettroPile;

public class Soffiatore extends ElettroPile {
	
	private String name;
	private boolean inserita;
	private boolean on;
	
	
	public Soffiatore(String name) {
		this.name = name;
	}
	
	public boolean isInserita() {
		inserita = new Random().nextInt(2) == 1;
		return inserita;
	}


	@Override
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
	
	public int getPotenza() {
		return new Random().nextInt(2500, 3001); 
	}

}
