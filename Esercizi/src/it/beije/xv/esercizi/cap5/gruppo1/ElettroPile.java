package it.beije.xv.esercizi.cap5.gruppo1;

import java.util.Random;

import it.beije.xv.esercizi.cap5.gruppo1.HaPile;


public abstract class ElettroPile extends Elettrodomestici implements HaPile {
	
	public int carica;
	
	public boolean caricato = false;
	
	public abstract boolean isOn();

	public abstract void setName(String name);
	
	public void setCarica(int aCarica) {
		caricato = true;
		carica = aCarica;
	}
	
	public abstract String getName();
	
	public int getCarica() {
		if( caricato )
			return carica;
		else
			return new Random().nextInt(100);
	}
	
	
}
