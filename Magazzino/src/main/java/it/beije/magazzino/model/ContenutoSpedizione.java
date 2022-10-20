package it.beije.magazzino.model;

import javax.persistence.*;

@Entity
@Table(name = "contenuto_spedizione")
public class ContenutoSpedizione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "spedizione_id")
    private Integer spedizione_id;

    @Column(name = "`prodotto_id`")
    private Integer prodotto_id;

    @Column(name = "quantita")
    private Integer quantita;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpedizione_id() {
        return spedizione_id;
    }

    public void setSpedizione_id(Integer spedizione_id) {
        this.spedizione_id = spedizione_id;
    }

    public Integer getProdotto_id() {
        return prodotto_id;
    }

    public void setProdotto_id(Integer prodotto_id) {
        this.prodotto_id = prodotto_id;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return "contenuto_spedizione{" +
                "id=" + id +
                ", spedizione_id=" + spedizione_id +
                ", prodotto_id=" + prodotto_id +
                ", quantita=" + quantita +
                '}';
    }
}
