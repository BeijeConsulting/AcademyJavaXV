package it.beije.magazzino.model;

import javax.persistence.*;

/*
   CREATE TABLE `magazzino`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `tipologia` VARCHAR(12) NOT NULL,
  `quantita` INT NOT NULL,
  `descrizione` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));
*/
@Entity
@Table(name="products")
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="tipologia")
    private String tipologia;

    @Column(name="quantita")
    private Integer quantita;

    @Column(name = "descrizione")
    private String descrizione;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
