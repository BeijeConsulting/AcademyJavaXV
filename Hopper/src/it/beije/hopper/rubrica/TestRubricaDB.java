package it.beije.hopper.rubrica;

import it.beije.hopper.Contatto;

import java.sql.SQLException;
import java.util.Scanner;

public class TestRubricaDB {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cosa vuoi fare? \n 0 - cerca contatto \n 1 - inserisci contatto \n 2 - modifica contatto \n 3 - elimina contatto");
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
                break;
            }
            case "1": {
                Contatto contatto = new Contatto();
                System.out.println("Inserisci il nome del contatto");
                String nome = scanner.nextLine();
                System.out.println("Inserisci il cognome del contatto");
                String cognome = scanner.nextLine();
                System.out.println("Inserisci il telefono del contatto");
                String telefono = scanner.nextLine();
                System.out.println("Inserisci l'e-mail del contatto");
                String email = scanner.nextLine();
                System.out.println("Inserisci eventuali note del contatto");
                String note = scanner.nextLine();

                contatto.setNome(nome);
                contatto.setCognome(cognome);
                contatto.setTelefono(telefono);
                contatto.setEmail(email);
                contatto.setNote(note);

                RubricaMethodsDB.inserisciContattoDB(contatto);
                break;
            }
            case "2": {
                RubricaMethodsDB.listaDB();
                System.out.println("Inserisci l'id del contatto che vuoi modificare:");
                String id = scanner.nextLine();
                System.out.println("Inserisci il campo che vuoi modificare:");
                String campo = scanner.nextLine();
                System.out.println("Inserisci il nuovo valore:");
                String nuovoValore = scanner.nextLine();

                RubricaMethodsDB.modificaContattoDB(id, campo, nuovoValore);
                break;
            }
            case "3": {
                RubricaMethodsDB.listaDB();
                System.out.println("Inserisci l'id del contatto che vuoi eliminare:");
                String id = scanner.nextLine();
                RubricaMethodsDB.eliminaContattoDB(id);
                break;
            }
        }
    }
}