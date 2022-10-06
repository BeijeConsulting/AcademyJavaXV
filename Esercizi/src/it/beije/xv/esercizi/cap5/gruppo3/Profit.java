package it.beije.xv.esercizi.cap5.gruppo3;
public abstract interface Profit {

    public String scopo = "PROFIT";
    public String costituzione = "Atto notarile";

    public boolean agevolazioni = false;

    public abstract int getUtile();
    public abstract String getBilancio();


}
