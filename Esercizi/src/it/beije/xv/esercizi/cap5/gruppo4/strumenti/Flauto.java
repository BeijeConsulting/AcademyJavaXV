package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public class Flauto extends StrumentoAFiato implements Seduto{

    public Flauto() {
        nome = "Flauto";
        dimensione = "Piccolo";
        materiale = "Legno";
        numeroChiavi = 12;
    }
    public void getInfo() {
        System.out.println(nome);
        System.out.println(dimensione);
        System.out.println(materiale);
        System.out.println(numeroChiavi);
        System.out.println("Da seduto: " + daSeduto());
        System.out.println();
    }

}
