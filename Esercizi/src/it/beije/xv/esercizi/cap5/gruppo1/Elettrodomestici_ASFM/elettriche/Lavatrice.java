package it.beije.java.xv.esercizi.elettriche;

import java.util.Random;

import it.beije.java.xv.esercizi.Elettrodomestici.ElettroCorrente;
import it.beije.java.xv.esercizi.Interfacce.TimerInterface;

//import java.util.Timer;
//import java.util.TimerTask;

public class Lavatrice extends ElettroCorrente implements TimerInterface {
	
	private String name;
	private boolean collegato;
	private boolean on;
	private int time = 0;
	
	public Lavatrice( String name ) {
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

	
	public void setTime(int time) throws IllegalArgumentException {
		if( time > 0 ) {
			this.time = time;
		}else {
			throw new IllegalArgumentException("Time deve essere maggiore di 0.");
		}
	}
	
	public int getTime() {
		return time;
	}
	
	public String getName() {
		return name;
	}



	public double potenza() {
		return new Random().nextDouble(1.85, 2.88);
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
	
	public boolean isColorati(String colori) {
			if(colori.toUpperCase().equals("BIANCHI")) {
				System.out.println("Bianchi selezionato.");
				return false;
			}
			
			System.out.println("Colorati selezionato.");
			return true;
	}

	
	public boolean isOver() {
		
		return true;
	}

	@Override
	public void diminuisci(int count) {
		// TODO Auto-generated method stub
		if( time > 0 ) {
			time -=count;	
		}
		
	}

}

/*
class ScriviDurata extends TimerTask {
	
    int durata = 60;
   
    public void run() {
      if (durata > 0) {
        System.out.println("Restano " + durata + " secondi");
        durata--;
      }else{
        System.out.println("FINE!");
        System.exit(0);
      }
    }
}

class CountDown {
	  
	  Timer timer;
	  
	  public CountDown() {
	    timer = new Timer();
	    timer.schedule(new ScriviDurata(), 0, 1000);
	  }

	  
}

*/
