package it.beije.hopper;

public class Singleton {
	
	public static int risorsa = 10;
	
	private static Singleton singleton = null;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		
		return singleton;
	}

}
