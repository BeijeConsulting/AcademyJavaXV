package it.beije.java.xv.esercizi.array;

import java.util.HashMap;


/*
 
 Scrivere il metodo: “public int mostRecurrent(int [] array)” , 
 che trova l’elemento più ricorrente in un array. Il metodo restituisce l’elemento trovato.
 
  */

public class MostRecurrent {
	//key(valore) value(ricorrenza) --> O(n)
	private HashMap<Integer, Integer> set = new HashMap<>();
	
	
	public int mostRecurrent(int[] array) {
		int[] maxRecurrenceAndPos = {0,-1};
		
		
		//Iteration to fill up the hashset
		for( int i = 0; i < array.length; i++) {
			if( set.containsKey(array[i])) {
				//update
				int currentValueAtKey = set.get(array[i]);
				set.put(array[i], ++currentValueAtKey);
				
			}else {
				//add key, value = 1 ( recurs )
				set.put( array[i], 1);
			}
		}
		
		for( Integer val : set.keySet() ) {
			if( set.get(val) > maxRecurrenceAndPos[0] ) {
				maxRecurrenceAndPos[0] = set.get(val);
				maxRecurrenceAndPos[1] = val; //return value
			}
		}

		
		return maxRecurrenceAndPos[1];
	}
	
	public static void main(String[] args) {
		int[] tester = {4,4,4,3,2}; //{4,4,4,3,2,33,1,23,4,5,6,78,2,1,23,4,5,6,-1,-1,-1,-1,-1,2,3,4,5,6,78,5};
		MostRecurrent mr = new MostRecurrent();
		System.out.println(mr.mostRecurrent(tester));
	}
	
}
