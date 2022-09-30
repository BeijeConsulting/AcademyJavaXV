package it.beije.hopper.eserciziGenerici;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class MorraCinese {
    public static void main(String[] args) {
        morraCinese();

    }

    public static void morraCinese() {
        String[] str = new String[3];
        String[] morraCineseArray = {"carta", "sasso", "forbici"};

        for (int i = 0; i < 2; ) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Inserisci stringa (giocatore " + (i + 1) + "): ");
            str[i] = sc.nextLine();
            if (str[i].equalsIgnoreCase("carta") || str[i].equalsIgnoreCase("sasso") ||
                    str[i].equalsIgnoreCase("forbici"))
                i++;
            else
                System.out.println("Stringa non accettata");
        }

        if (Arrays.asList(morraCineseArray).indexOf(str[0].toLowerCase()) == (Arrays.asList(morraCineseArray).indexOf(str[1].toLowerCase()) - 1) ||
                Arrays.asList(morraCineseArray).indexOf(str[0].toLowerCase()) == (Arrays.asList(morraCineseArray).indexOf(str[1].toLowerCase()) + 2))
            System.out.println("Vittoria Giocatore 1");
        else if (Arrays.asList(morraCineseArray).indexOf(str[0].toLowerCase()) == Arrays.asList(morraCineseArray).indexOf(str[1].toLowerCase()))
            System.out.println("Pareggio");
        else System.out.println("Vittoria Giocatore 2");

    }
}
