package it.beije.hopper;

import javax.persistence.*;

@Entity
@Table(name = "recapiti")
public class Recapito {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRubrica_id() {
        return rubrica_id;
    }

    public void setRubrica_id(int rubrica_id) {
        this.rubrica_id = rubrica_id;
    }

    public String getRecapito() {
        return recapito;
    }

    public void setRecapito(String recapito) {
        this.recapito = recapito;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rubrica_id")
    private int rubrica_id;

    @Column(name = "recapito")
    private String recapito;

    @Column(name = "tipo")
    private char tipo;

    @Column(name = "descr")
    private String descr;

}


