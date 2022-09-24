package it.beije.java.xv.esercizi.elettriche;

import java.util.Random;

import it.beije.java.xv.esercizi.Elettrodomestici.ElettroCorrente;
import it.beije.java.xv.esercizi.Interfacce.Cucinare;
import it.beije.java.xv.esercizi.Interfacce.Scalda;

public class Fornello extends ElettroCorrente implements Scalda, Cucinare {
	
	private int numeroFuochi;
	private boolean collegato;
	private boolean on;
	private String name;
	private int temperature;
	
	
	public Fornello(String name) {
		this.name = name;
		numeroFuochi = 0;
	}
	
	
	
	public Fornello(int aNumeroFuochi, String name) {
		this(name);
		numeroFuochi = aNumeroFuochi;
	}
	
	public int getNumeroFuochi() {
		return numeroFuochi;
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





	
	public int tipologia() {
		int tipo = new Random().nextInt(2);
		switch( tipo ) {
			case 0:
				System.out.println("1: Fritto");
			default:
				System.out.println("2: Bollito");
		}
		return tipo+1;
	}

	
	public boolean isScalda() {
		return true;
	}


	public void setTemp(int aTemperature) {
		temperature = aTemperature;
	}

	@Override
	public int getTemp() {
		return temperature;
	}

	
	public double potenza(int mq) {
		return -1;
	}
	
	public double potenza() { 
		return 0;
	}

	public void setIsOn(boolean on) {
		if( isCollegato() ) 
			on = true;
		else
			on = false;
	}

}
