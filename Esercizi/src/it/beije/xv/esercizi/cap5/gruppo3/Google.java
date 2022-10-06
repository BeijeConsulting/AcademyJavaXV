package it.beije.xv.esercizi.cap5.gruppo3;
public class Google extends SRL implements SRLINTERFACE, Pubblica, NoProfit{

    public static String rendiconto;
    public static boolean privata = false;

    public Google(){
        super("Beneficenza","Google", "Via Milano 12/A, 20100", "r4q3trfer34g", "normale", 5, 30, 2 );
    }
    public void stampaDati() {
        System.out.println("Settore: "+this.getSettore());
        System.out.println("Nome: "+this.getname());
        System.out.println("Sede: "+this.getregisteredOffice());
        System.out.println("P.IVA: "+this.getPIVA());
        System.out.println("CAP. SOCIALE: "+this.getCapSociale());
        System.out.println("PRIVATA: "+this.isPubblica());
        System.out.print("\n");
    }

    public String getRendiconto() {
        return rendiconto;
    }

    public boolean isPubblica() {
        return privata;
    }
}
