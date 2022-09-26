package it.beije.java.xv.esercizi.elettriche;

import java.util.Random;

import it.beije.java.xv.esercizi.Elettrodomestici.ElettroCorrente;

public class Aspirapolvere extends ElettroCorrente {

	private boolean collegato;
	private boolean on;
	private String name;
	
	public Aspirapolvere(String name) {
		this.name = name;
	}
	public boolean isCollegato() {
		collegato = new Random().nextInt(1) == 1;
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
		return (double)new Random().nextInt(1,3);
	}

	
	public void setIsOn(boolean on) {
		if( isCollegato() ) 
			on = true;
		else
			on = false;
	}

	public int livelloPolvere() {
		return new Random().nextInt(0,11);
	}

	
	public double potenza(int mq) {	
		return -1;
	}

}
