//DA FINIRE

package it.beije.java.xv.esercizi.pile;

import java.util.Random;

import it.beije.java.xv.esercizi.Elettrodomestici.ElettroPile;

public class Telecomando extends ElettroPile {
	
	private boolean inserita;
	
	@Override
	public boolean isInserita() {
		inserita = new Random().nextInt(2) == 1;
		return inserita;
	}

	@Override
	public boolean isOn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIsOn(boolean on) {
		// TODO Auto-generated method stub
		
	}

}
