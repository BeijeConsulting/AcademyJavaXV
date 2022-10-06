package it.beije.xv.esercizi.cap5.gruppo3;
public class Beije extends SRL implements SRLINTERFACE, Privata, Profit{

    public static int utile;
    public static String bilancio;
    public static boolean privata = true;

    public Beije(){
        super("Consulenza","Beije", "Via Varese, 27/38, Lissone (MB)", "16334941008", "normale", 1000000, 200, 5);
    }

    public int getUtile() {
        return utile;
    }

    public String getBilancio() {
        return bilancio;
    }

    public boolean isPrivata() {
        return privata;
    }

    public void stampaDati() {
        System.out.println("Settore: "+this.getSettore());
        System.out.println("Nome: "+this.getname());
        System.out.println("Sede: "+this.getregisteredOffice());
        System.out.println("P.IVA: "+this.getPIVA());
        System.out.println("CAP. SOCIALE: "+this.getCapSociale());
        System.out.println("PRIVATA: "+this.isPrivata());
        System.out.print("\n");
    }
}
