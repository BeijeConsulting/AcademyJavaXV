package it.beije.java.xv.esercizi.array;

//() 8 Trovare il massimo elemento in un array (o il minimo)

public class MaxAndMin {
	
	public int max( int[] values ) {
		int max = values[0];
		for(int i = 1; i < values.length; i++ ) {
			if( values[i] > max) {
				max = values[i];
			}
		}
		
		return max;
	}
	
	public int min( int[] values) {
		 int min = values[0];
		for( int i = 1; i < values.length; i++ ) {
			if( values[i] < min ) min = values[i];
		}
		return min;
	}
	
	public static void main(String[] args) {
		int[] test = {5,4,6,2,3,1,2,5,6};
		MaxAndMin maxMin = new MaxAndMin();
		System.out.println(maxMin.max(test));
		System.out.println(maxMin.min(test));
	}
	
}
