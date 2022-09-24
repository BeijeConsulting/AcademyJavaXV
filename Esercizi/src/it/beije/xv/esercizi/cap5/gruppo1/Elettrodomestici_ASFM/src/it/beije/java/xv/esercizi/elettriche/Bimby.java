package it.beije.java.xv.esercizi.elettriche;

import java.util.Random;

import it.beije.java.xv.esercizi.Elettrodomestici.ElettroCorrente;

public class Bimby extends ElettroCorrente {

	private boolean collegato;
	private boolean on;
	private String name;
	
	public Bimby(String name) {
		this.name = name;
	}
	
	public boolean isCollegato() {
		collegato = new Random().nextInt(2) == 1;
		return collegato;
	}

	public boolean isOn() {
		
		if( !isCollegato() )
			return false;
		
		return on;
	}

	public void setName(String aName) {
		name = aName;
	}

	public String getName() {
		return name;
	}


	
	public double potenza() {
		return 1.5;
	}
	
	
	public double potenza(int mq) {		
		return -1;
	}

	
	public void setIsOn(boolean on) {
		if( isCollegato() ) 
			on = true;
		else
			on = false;
	}
	
	public boolean isAllIngredients() {
		return new Random().nextInt(2) == 1;
	}
}
