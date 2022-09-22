package it.beije.hopper.rubrica;

import java.util.Scanner;

public class TestRubricaDB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cosa vuoi fare? " + "\n 0 - cerca contatto");
        String scelta = scanner.nextLine();

        switch (scelta) {
            case "0": {
                System.out.println("Specifica il campo che vuoi ricercare (Nome, Cognome, Telefono o Email)");
                String campo = scanner.nextLine();
                if (!campo.equalsIgnoreCase("Nome") || campo.equalsIgnoreCase("Cognome") || campo.equalsIgnoreCase("Telefono") || campo.equalsIgnoreCase("Email")) {
                    System.out.println("Campo non valido");
                } else {
                    System.out.println("Inserisci il parametro che stai cercando:");
                    String campoNome = scanner.nextLine();
                    RubricaMethodsDB.cercaContattoDB(campo, campoNome);
                }
            }
        }
    }
}
