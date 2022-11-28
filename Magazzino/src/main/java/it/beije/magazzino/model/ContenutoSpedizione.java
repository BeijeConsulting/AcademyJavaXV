package it.beije.magazzino.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "contenuto_spedizione")
public class ContenutoSpedizione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "spedizione_id")
    private Integer spedizioneId;
    @JsonIgnore
    @Column(name = "prodotto_id")
    private Integer prodottoId;

    @Column(name = "quantita")
    private Integer quantita;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpedizioneId() {
        return spedizioneId;
    }

    public void setSpedizioneId(Integer spedizioneId) {
        this.spedizioneId = spedizioneId;
    }

    public Integer getProdottoId() {
        return prodottoId;
    }

    public void setProdottoId(Integer prodottoId) {
        this.prodottoId = prodottoId;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }


    @Override
    public String toString() {
        return "ContenutoSpedizione{" + "id=" + id + ", spedizioneId=" + spedizioneId + ", prodottoId=" + prodottoId + ", quantita=" + quantita + '}';
    }
}
