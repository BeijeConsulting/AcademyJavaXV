package it.beije.java.xv.esercizi.array;
/*
	Verificare la sequenza crescente di un array. 
	Il metodo “boolean isCrescente(int [] array)” 
	restituisce true se tutti gli elementi dell’array passato sono in ordine crescente, false altrimenti.
*/
public class IsCrescente {
	public boolean isCrescente(int[] array) {
		for( int i = 1; i< array.length;i++) {
			if( array[i-1] > array[i]) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println( new IsCrescente().isCrescente(new int[]{1,2,3,4,5,6}) );
		System.out.println( new IsCrescente().isCrescente(new int[]{1,2,3,4,5,-1}) );
		System.out.println( new IsCrescente().isCrescente(new int[]{1,-22,3,4,5,6}) );
		System.out.println( new IsCrescente().isCrescente(new int[]{1,2,0,4,5,6}) );
		System.out.println( new IsCrescente().isCrescente(new int[]{11,22,433,534,655,766}) );
	}
}
