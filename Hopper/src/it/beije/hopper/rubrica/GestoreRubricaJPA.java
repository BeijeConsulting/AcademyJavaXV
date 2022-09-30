package it.beije.hopper.rubrica;

import it.beije.hopper.Contatto;
import it.beije.hopper.Recapito;

import java.util.ArrayList;
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
            case "12": {
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
            case "1": {
                Contatto contatto = new Contatto();
                ArrayList<Recapito> recapiti = new ArrayList<>();
                System.out.println("Inserisci il nome del contatto");
                String nome = scanner.nextLine();
                contatto.setNome(nome);
                System.out.println("Inserisci il cognome del contatto");
                String cognome = scanner.nextLine();
                contatto.setCognome(cognome);
                System.out.println("Inserisci le note del contatto");
                String note = scanner.nextLine();
                contatto.setNote(note);

                System.out.println("Vuoi aggiungere un recapito?\nY se 'si'' \n N se 'no'");
                String conferma = scanner.nextLine();
                if (conferma.equalsIgnoreCase("Y") || conferma.equalsIgnoreCase("N")) {
                    while (conferma.toLowerCase().equals("y")) {
                        Recapito recapito = new Recapito();
                        System.out.println("Inserisci il tipo del recapito (\n'T' se telefono \n 'E' se email");
                        String tipo = scanner.nextLine();
                        if (tipo.equalsIgnoreCase("T") || tipo.equalsIgnoreCase("E")) {
                            recapito.setTipo(tipo.charAt(0));
                        } else {
                            System.out.println("Scelta errata");
                            continue;
                        }
                        System.out.println("Inserisci il recapito del contatto");
                        String r = scanner.nextLine();
                        recapito.setRecapito(r);
                        System.out.println("Inserisci la descrizione del recapito");
                        String desc = scanner.nextLine();
                        recapito.setDescr(desc);
                        recapiti.add(recapito);
                        System.out.println("Vuoi aggiungere un altro recapito?\nY se 'si'' \n N se 'no'");
                        conferma = (scanner.nextLine());

                    }
                    RubricaMethodsJPA.newInserisciContattoJPA(contatto, recapiti);
                } else {
                    RubricaMethodsJPA.newInserisciContattoJPA(contatto, recapiti);
                }
                break;
            }
            default: {
                System.out.println("Scelta errata");
            }
        }
        RubricaMethodsJPA.entityManager.close();
    }

}
