package it.beije.xv.esercizi.cap5.gruppo1;

import it.beije.xv.esercizi.cap5.gruppo1.Fornello;
import it.beije.xv.esercizi.cap5.gruppo1.Soffiatore;

public class DemoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Soffiatore soffiatore = new Soffiatore("Soffiatore1");
//		System.out.println(soffiatore.getName());
//		soffiatore.setName("NonSoffiatore1");
//		System.out.println(soffiatore.getName());
		
		Fornello fornello1 = new Fornello("Fornello1");
		Fornello fornello2 = new Fornello(1, "Fornello2");
		
		System.out.println(fornello1.getName());
		System.out.println(fornello2.getName());
		
		
		
		
	}

}
