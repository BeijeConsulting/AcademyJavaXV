package it.beije.xv.esercizi.cap5.gruppo3;
public abstract class SRLS extends Azienda implements SRLINTERFACE{
    public String settore, name, registeredOffice, PIVA, tipo;
    public int capSociale, employees, partner;

    public SRLS (String settore, String name, String registeredOffice, String PIVA, String tipo, int capSociale, int employees, int partner){
        this.settore = settore;
        this.name = name;
        this.PIVA = PIVA;
        this.registeredOffice = registeredOffice;
        this.tipo = tipo;
        this.capSociale = capSociale;
        this.employees = employees;
        this.partner = partner;
    }

    public String getSettore(){
        return settore;
    }

    public String getTipo(){
        return tipo;
    }

    public String getname() {
        return name;
    }

    public String getregisteredOffice() {
        return registeredOffice;
    }

    public String getPIVA() {
        return PIVA;
    }

    public int getCapSociale() {
        return capSociale;
    }

    public int getEmployees() {
        return employees;
    }

    public int getPartner() {
        return partner;
    }
}
