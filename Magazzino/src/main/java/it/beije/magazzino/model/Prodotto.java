/*
CREATE TABLE `hopper`.`prodotto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `tipologia` VARCHAR(100) NULL,
  `quantita` INT NOT NULL,
  `descrizione` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`));
 */
package it.beije.magazzino.model;

public class Prodotto {

    private int id;
    private String nome;
    private String tipologia;
    private int quantita;
    private String descrizione;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
