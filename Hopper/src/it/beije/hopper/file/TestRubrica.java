package it.beije.hopper.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.beije.hopper.Contatto;

public class TestRubrica {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cosa vuoi fare? " + "0 - cerca contatto" + "1 - Inserisci contatto");

        WriteRubrica writeRubrica = new WriteRubrica();
        String path = "C:/test/rubrica.csv";
        String sep = ";";
        List<Contatto> contatti = new ArrayList<Contatto>(WriteRubrica.loadRubricaFromCSV(path, sep));
        String scelta = scanner.nextLine();

        switch (scelta) {
            case "0": {
                System.out.println("Inserisci il nome da ricercare:");
                String nomeRicercato = scanner.nextLine();
                writeRubrica.cercaContatto(nomeRicercato);
                break;
            }
            case "1": {
                System.out.println("Digita il nome del contatto.");
                String nomeRicercato = scanner.nextLine();
                System.out.println("Digita il cognome del contatto.");
                String cognomeRicercato = scanner.nextLine();
                System.out.println("Digita il telefono del contatto.");
                String telefonoRicercato = scanner.nextLine();
                System.out.println("Digita l'email del contatto.");
                String emailRicercato = scanner.nextLine();
                writeRubrica.inserisciContatto(cognomeRicercato, nomeRicercato, telefonoRicercato, emailRicercato);
                break;
            }

        }

    }

}
