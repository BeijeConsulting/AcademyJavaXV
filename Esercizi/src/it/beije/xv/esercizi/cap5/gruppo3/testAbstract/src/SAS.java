public abstract class SAS extends Azienda implements SASINTERFACE {

    public String settore, name, registeredOffice, PIVA, tipo;
    public boolean pubblica, profit;
    public int capSociale, employees, partner;

    public String[] accomandanti = {"Pippo", "Pluto", "Paperino"};
    public String[] accomandatari = {"Ciccio", "Pasticcio", "Topolino"};

    public SAS (String settore, String name, String registeredOffice, String PIVA, String tipo, boolean pubblica, boolean profit, int capSociale, int employees, int partner){
        this.settore = settore;
        this.name = name;
        this.PIVA = PIVA;
        this.registeredOffice = registeredOffice;
        this.tipo = tipo;
        this.pubblica = pubblica;
        this.profit = profit;
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

    public boolean isPublic() {
        return pubblica;
    }

    public boolean isProfit() {
        return profit;
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

    public String[] getAccomandanti() {
        return accomandanti;
    }

    public String[] getAccomandatari() {
        return accomandatari;
    }
}
