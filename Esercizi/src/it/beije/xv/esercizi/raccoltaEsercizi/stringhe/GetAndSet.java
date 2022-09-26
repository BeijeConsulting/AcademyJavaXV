package it.beije.java.xv.esercizi.stringhe;

public class GetAndSet {
	/*
	 () 6 Scrivere un metodo che, data una stringa in input, assuma questa come un nome di variabile e stampi per questa variabile il suo metodo “setter”
	() 7 Scrivere un metodo che, data una stringa in input, assuma questa come un nome di variabile e stampi per questa variabile il suo metodo “getter”
	 *
	 */
	public String setter(String input) {
		return "void " + input + " ( String " + input +" );";
	}
	
	public String getter(String input) {
		return "String " + input + "( String " + input + ");";
	}
	
	public static void main(String[] args) {
		System.out.println(new GetAndSet().setter("Nome"));
		System.out.println(new GetAndSet().getter("Nome"));
	}
	
}
