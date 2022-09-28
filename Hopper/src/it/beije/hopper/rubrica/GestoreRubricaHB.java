package it.beije.hopper.rubrica;

import it.beije.hopper.Contatto;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestoreRubricaHB {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Cosa vuoi fare? \n 0 - lista contatti \n 1 - inserisci contatto \n 2 - cerca contatto \n 3 - elimina contatto \n 4 - modifica contatto");
        Scanner scanner = new Scanner(System.in);
        String scelta = scanner.nextLine();

        switch (scelta) {
            case "0": {
                RubricaMethodsHBM.listaHBM();
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
                RubricaMethodsHBM.inserisciContattoHBM(contatto);
                break;
            }
            case "2": {
                System.out.println("Inserisci il nome del contatto che stai cercando");
                String nome = scanner.nextLine();
                RubricaMethodsHBM.cercaContattoHBM(nome);
                break;
            }
            case "3": {
                Contatto contatto = null;
                RubricaMethodsHBM.listaHBM();
                System.out.println("Inserisci l'id del contatto che vuoi eliminare:");
                Integer id = Integer.valueOf(scanner.nextLine());
                List<Contatto> lista = RubricaMethodsHBM.listNoPrint();
                for (Contatto c : lista) {
                    if (c.getId() == id) {
                        contatto = c;
                        RubricaMethodsHBM.eliminaContattoHBM(contatto);
                        break;
                    }
                }
            }
            case "4": {
                RubricaMethodsHBM.listaHBM();
                System.out.println("Inserisci l'id del contatto che vuoi modificare:");
                String id = scanner.nextLine();
                System.out.println("Inserisci il campo che vuoi modificare:");
                String campo = scanner.nextLine();
                System.out.println("Inserisci il nuovo valore:");
                String nuovoValore = scanner.nextLine();
                RubricaMethodsDB.modificaContattoDB(id, campo, nuovoValore);
                break;
            }
            default: {
                System.out.println("inserisci un valore valido");
                break;
            }
        }
    }
}
