package it.beije.xv.esercizi.raccoltaEsercizi.cicli;

//7 Scrivere un programma che stampi i primi 100 elementi della successione di Fibonacci.
public class ExSeven {

	public void exSevenRecursive(int value) {
		System.out.println(recFibonacci(value));
	}
	private int recFibonacci(int val) {
		System.out.println(" " + val);
		if( val <= 1) return 1;
		
		return recFibonacci(val-2) + recFibonacci(val-1);
	}
	
	
	public static void main(String[] args) {
		ExSeven seven = new ExSeven();
		seven.exSevenRecursive(5);
	}
}
