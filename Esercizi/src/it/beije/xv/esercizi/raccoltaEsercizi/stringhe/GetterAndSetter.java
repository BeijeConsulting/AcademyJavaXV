package it.beije.java.xv.esercizi.stringhe;

// Scrivere un metodo che, data una 
// stringa in input, assuma questa come un nome di
// variabile e stampi per questa variabile il suo metodo “setter”


// Scrivere un metodo che, data una stringa 
// in input, assuma questa come un nome di variabile 
// e stampi per questa variabile il suo metodo “getter”
public class GetterAndSetter {
	private String set;

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}
	
	public void setter() {
		setSet(set);
		System.out.println("setter");
	}
	
	public void getter() {
		
	}
	
}
