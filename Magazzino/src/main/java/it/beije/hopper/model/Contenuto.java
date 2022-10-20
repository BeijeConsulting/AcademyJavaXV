package it.beije.hopper.model;

import javax.persistence.*;

/*
CREATE TABLE contenuto
        (
        id           INT AUTO_INCREMENT NOT NULL,
        idSpedizione INT                NULL,
        idProdotto   INT                NULL,
        quantita     INT                NULL,
        CONSTRAINT pk_contenuto PRIMARY KEY (id)
        );

        ALTER TABLE contenuto
        ADD CONSTRAINT FK_CONTENUTO_ON_IDSPEDIZIONE FOREIGN KEY (idSpedizione) REFERENCES spedizione (id);
*/

@Entity
@Table(name = "contenuto")
public class Contenuto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "idSpedizione")
    private Integer idSpedizione;

    @Column(name = "idProdotto")
    private Integer idProdotto;

    @Column(name = "quantita")
    private Integer quantita;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("{ id : ").append(this.id)
                .append(", id_prod : ").append(this.getId_prodotto())
                .append(", id_sped : ").append(this.getId_spedizione())
                .append(", quantità : ").append(this.quantita)
                .append(" }");
        return builder.toString();
    }

    public Integer getId_spedizione() {
        return idSpedizione;
    }

    public void setId_spedizione(Integer idSpedizione) {
        this.idSpedizione = idSpedizione;
    }

    public Integer getId_prodotto() {
        return idProdotto;
    }

    public void setId_prodotto(Integer idProdotto) {
        this.idProdotto = idProdotto;
    }
}
