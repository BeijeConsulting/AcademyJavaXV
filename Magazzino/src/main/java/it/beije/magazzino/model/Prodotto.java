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

import javax.persistence.*;

@Entity
@Table(name = "prodotto")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipologia")
    private String tipologia;

    @Column(name = "quantita")
    private Integer quantita;

    @Column(name = "descrizione")
    private String descrizione;

    public Prodotto(){}

    public Prodotto(String nome, String tipo, int quantita, String descrizione){
        if (nome == null || nome.equals("")) {
           throw  new IllegalArgumentException("Nome cannot be empty");
        } else {
           this.nome = nome;
        }
        if (tipo == null || tipo.equals("")) {
            throw new IllegalArgumentException("Tipologia cannot be empty");
        } else {
            this.tipologia = tipo;
        }
       if(quantita < 0){
            throw new IllegalArgumentException("Quantità cannot be less than 0");
        }else{
            this.quantita = quantita;
        }
        if (descrizione == null || descrizione.equals("")) {
            this.descrizione = "Descrizione non disponibile";
        } else {
            this.descrizione = descrizione;
        }
    }

    public Prodotto(Integer id, String nome, String tipo, int quantita, String descrizione){
        if (nome == null || nome.equals("")) {
            throw  new IllegalArgumentException("Nome cannot be empty");
        } else {
            this.nome = nome;
        }
        if (tipo == null || tipo.equals("")) {
            throw new IllegalArgumentException("Tipologia cannot be empty");
        } else {
            this.tipologia = tipo;
        }
        if(quantita < 0){
            throw new IllegalArgumentException("Quantità cannot be less than 0");
        }else{
            this.quantita = quantita;
        }
        if (descrizione == null || descrizione.equals("")) {
            this.descrizione = "Descrizione non disponibile";
        } else {
            this.descrizione = descrizione;
        }

        this.id = id;
    }

    public Integer getId() {
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

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipologia='" + tipologia + '\'' +
                ", quantita=" + quantita +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
