package it.beije.xv.esercizi.mixed;

public interface Prova {

    public void prova();

    default public void pippo(){
        System.out.println("ciao");
    }

    static public void pippoTmp(){
        System.out.println("ciao 2");
    }
}
