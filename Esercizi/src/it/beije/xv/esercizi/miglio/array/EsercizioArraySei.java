package it.beije.xv.esercizi.miglio.array;
import java.util.*;

public class EsercizioArraySei {
	public static void main(String... args) {
		int[] numeri = new int[5];
		int totale = 0;
		int media = 0;
		int j = 0;
		Random random = new Random();
		for(int i = 0; i < numeri.length; i++) numeri[i] = random.nextInt(99);
		for(int i:numeri) {
			System.out.println(i);
			if((i % 3) == 0) {
				totale += i;
				j++;
			}
		}
		if(j != 0) media = totale / j;
		System.out.println(media);
	}
}