package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public class Fisarmonica extends StrumentoAFiato implements Seduto{

    public Fisarmonica() {
        nome = "Fisarmonica";
        dimensione = "Piccolo";
        materiale = "Metalo";
        numeroChiavi = 25;

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
