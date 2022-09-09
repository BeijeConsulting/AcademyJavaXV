package it.beije.xv.esercizi.cap5.gruppo4.strumenti;

public class Sassofono extends StrumentoAFiato implements Seduto{

    public Sassofono() {
        nome = "Flauto";
        dimensione = "Medio";
        materiale = "Metallo";
        numeroChiavi = 20;
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
