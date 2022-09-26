package it.beije.java.xv.esercizi.array;

public class StampaZigZag {

	public static void main(String[] args) {
		// Scrivere un programma StampaZigZag che, dato un array di 10 numeri interi contenente valori a piacere, ne stampa 
		//gli elementi secondo il seguente ordine: il primo, l�ultimo, il secondo, il penultimo, il terzo, il terz�ultimo, ecc�
		
		
		//TODO 
		int[] arr = {0,1,2,3,4,5,6,7,8,9,10};			
		int l = arr.length;   //length = 10
		
		for (int i = 0; i < arr.length/2; i++)
		{
			System.out.print(arr[i]+ " ");
			System.out.print(arr[l-1-i]+" ");
		}
	}
}
