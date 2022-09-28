package it.beije.hopper.rubrica;

import it.beije.hopper.Contatto;

import java.util.Scanner;

public class GestoreRubricaJPA {


    public static void main(String[] args) {
        System.out.println("Cosa vuoi fare? \n 0 - lista contatti \n 1 - inserisci contatto \n 2 - cerca contatto \n 3 - elimina contatto \n 4 - modifica contatto");
        Scanner scanner = new Scanner(System.in);
        String scelta = scanner.nextLine();

        switch (scelta) {
            case "0": {
                RubricaMethodsJPA.listJPA();
                break;
            }
            case "1": {
                Contatto contatto = new Contatto();
                System.out.println("Inserisci il nome del contatto");
                String nome = scanner.nextLine();
                contatto.setNome(nome);
                System.out.println("Inserisci il cognome del contatto");
                String cognome = scanner.nextLine();
                contatto.setCognome(cognome);
                System.out.println("Inserisci il telefono del contatto");
                String telefono = scanner.nextLine();
                contatto.setTelefono(telefono);
                System.out.println("Inserisci l'email del contatto");
                String email = scanner.nextLine();
                contatto.setEmail(email);
                System.out.println("Inserisci le note del contatto");
                String note = scanner.nextLine();
                contatto.setNote(note);
                RubricaMethodsJPA.inserisciContattoJPA(contatto);
                break;
            }
            case "2": {
                System.out.println("Inserisci il nome/cognome/telefono/email o le note del contatto che stai cercando");
                String valore = scanner.nextLine();
                RubricaMethodsJPA.cercaContattoJPA(valore);
                break;
            }
            case "3": {
                RubricaMethodsJPA.listJPA();
                System.out.println("Inserisci l'id del contatto che vuoi eliminare");
                String id = scanner.nextLine();
                RubricaMethodsJPA.eliminaContattoJPA(Integer.parseInt(id));
            }
            case "4": {
                RubricaMethodsJPA.listJPA();
                System.out.println("inserisci l'id");
                Integer id = Integer.valueOf(scanner.nextLine());
                System.out.println("inserisci il campo che vuoi modificare");
                String campo = scanner.nextLine();
                System.out.println("inserisci il nuovo valore");
                String valore = scanner.nextLine();
                RubricaMethodsJPA.modificaContattoJPA(campo, valore, id.intValue());
            }
            default: {
                System.out.println("Scelta errata");
            }
        }
        RubricaMethodsJPA.entityManager.close();
    }

}
