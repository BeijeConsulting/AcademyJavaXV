package it.beije.xv.esercizi.codetestsOCA.capitolo5.interfaces.example1;

public interface HasTail {
	public abstract int getTailLength();
	public default String getTailType() {
		return "Black tail";
	}
}
