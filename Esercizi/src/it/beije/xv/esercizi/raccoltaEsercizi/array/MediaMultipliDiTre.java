package it.beije.java.xv.esercizi.array;

// Scrivere un programma MediaMultipliDiTre che calcoli 
// la media di un array di numeri interi, 
// considerando i soli numeri divisibili per tre.
public class MediaMultipliDiTre {
	int test;
	public void mediaMultipliDi(int[] arr,int num ) {
		int avg = 0;
		
		for( int i = 0; i < arr.length; i++) {
			
			if(  arr[i] == num ) {
				avg+= arr[i];
			}
			
		}
		System.out.println();
	}
}
