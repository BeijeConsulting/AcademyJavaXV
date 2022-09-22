package it.beije.xv.esercizi.miglio.array;
import java.util.Scanner;

public class EsercizioArray {
	public static void main(String... args) {
		int[] num = {3, 3, 4, 5, 1, 43, 10, 90, 36, 71};
		int max = num[0], min = num[0];
		for(int i = 1; i < num.length; i++) {
			max = num[i] > max ? num[i] : max;
			min = num[i] < min ? num[i] : min;
		}
		System.out.println("Valore massimo: " + max);
		System.out.println("Valore minimo: " + min);
	}
}
