package it.beije.xv.esercizi.cap5.gruppo1;

import java.util.Random;

import it.beije.xv.esercizi.cap5.gruppo1.ElettroCorrente;

import it.beije.xv.esercizi.cap5.gruppo1.Raffredda;
import it.beije.xv.esercizi.cap5.gruppo1.Scalda;

public class Climatizzatore extends ElettroCorrente implements Scalda, Raffredda{
	
	private int temperature;
	private boolean collegato;
	private String name;
	private boolean on;
	
	public Climatizzatore(String name) {
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
		return -1;
	}
	
	public double potenza(int mq) {		
		return (double)mq*340;
	}

	
	public void setIsOn(boolean on) {
		if( isCollegato() ) 
			on = true;
		else
			on = false;
	}

	
	public boolean isRaffredda() {
		return true;
	}

	
	public boolean isScalda() {
		return true;
	}

	public void setTemp(int aTemperature) {
		temperature = aTemperature;
	}

	
	public int getTemp() {
		return temperature;
	}
	
	public String helloWorld() {
		return "Hello world!";
	}


	
	
}
