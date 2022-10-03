package it.beije.xv.esercizi.TestEL;

public class FunWithArgs {
    public static void main(String[][] args) {
        System.out.println(args[0][1]);
    }

    public static void main(String[] args) {
        FunWithArgs fwa = new FunWithArgs();
        String[][] newargs = {args};
        fwa.main(newargs);
    }
}