package it.beije.xv.esercizi.cap5.gruppo1;

import java.util.Random;

import it.beije.xv.esercizi.cap5.gruppo1.Cavo;

public abstract class ElettroCorrente extends Elettrodomestici implements Cavo{
	
	
	public abstract boolean isOn();

	
	public abstract void setName(String name);

	
	public abstract String getName();
	

	public int lunghezzaCavo() {
		return new Random().nextInt(1,6);
	}
	
	public abstract double potenza();
	public abstract double potenza(int mq);
	
}
