package it.beije.xv.esercizi.raccoltaEsercizi.cicli;

/*
 * 
Scrivere un programma che stampi i primi 100 elementi della successione di Fibonacci.

Scrivere un programma che stampi le n 
righe della successione di Fibonacci in questo modo:
1
1, 1
1, 1, 2
1, 1, 2, 3
1, 1, 2, 3, 5
1, 1, 2, 3, 5, 8
1, 1, 2, 3, 5, 8, 13
 * 
 * */
public class ExSevenEight {

	public static void main(String[] args) {
		// TODO Auto-generated method ;
		
		//Scrivere un programma che stampi i primi 100 elementi della successione di Fibonacci.
		long num1 = 0L;
		long num2 = 1L;
		long sum = 0L;
		
		int count = 100;
		
		System.out.print(" " + num1 + " " +num2+" ");
		
		for (int i = 2; i < count; i++)
		{
			sum = num1 + num2;
			num1 = num2;
			num2 = sum;
			System.out.print(sum + " ");
		}
		
		System.out.println();
		
		/*
		 * Scrivere un programma che stampi le n righe della successione di Fibonacci in questo modo:
			1
			1, 1
			1, 1, 2
			1, 1, 2, 3
			1, 1, 2, 3, 5
			1, 1, 2, 3, 5, 8
			1, 1, 2, 3, 5, 8, 13
		 */
		
		
		int riga = 10;
		
		System.out.println(1);
		for(int i = 0; i < riga; i++)
		{
			int somma =0;
			int numero1=0;
			int numero2=1;
			
			System.out.print(numero2+", ");
			
			for (int j = 0; j <= i; j++)
			{
				somma = numero1 + numero2;
				numero1 = numero2;
				numero2 = somma;
				if (j!=i)
					System.out.print(somma + ", ");
				else 
					System.out.print(somma);
				
			}
			System.out.println();
		}

	}

}
