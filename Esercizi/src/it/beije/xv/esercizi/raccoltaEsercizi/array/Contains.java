package it.beije.java.xv.esercizi.array;
/*
	Scrivere un metodo “boolean contains(int e, int[] array)” 
	che restituisca true se l’elemento e è presente nell’array, false altrimenti. 
	Ripetere l’esercizio con “boolean contains(Object e, Object[] array)”, quali differenze ci sono?

	 “boolean contains(Object e, Object[] array)”, quali differenze ci sono?
	 
	 “boolean contains(Object e, Object[] array)”
	 puo' ricevere in input qualsiasi oggetto, bisognera' quindi gestire l' aspetto
	 della compatibilita' degli oggetti ( se sono lo stesso oggetto o meno ) durante il confronto
	 e controllare effettivamente se gli oggetti sono uguali o meno.
	 
 */
public class Contains {
	public boolean contains(int e, int[] array) {
		for( int i = 0; i< array.length; i++ ) {
			if( array[i] == e ) return true;  
		}
		return false;
	}
	
	boolean contains(Object e, Object[] array) {
		for( int i = 0; i < array.length; i++) {
			
		}
		return false;
	}
	
	DA FINIRE
	private boolean equals(Object e1, Object e2 ) {
		if( e1 == e2 ) return true;
		
		if( e1.getClass() != e2.getClass() ) return false;
		
		
		return false;
	}
}
