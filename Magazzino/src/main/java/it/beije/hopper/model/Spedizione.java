package it.beije.hopper.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/*
CREATE TABLE spedizione
(
    id              INT AUTO_INCREMENT NOT NULL,
    codice          VARCHAR(255)       NULL,
    destinatario    VARCHAR(255)       NULL,
    indirizzo       VARCHAR(255)       NULL,
    data_spedizione datetime           NULL,
    data_ricezione  datetime           NULL,
    CONSTRAINT pk_spedizione PRIMARY KEY (id)
);
*/

@Entity
@Table(name = "spedizione")
public class Spedizione {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "codice")
    private String codice;

    @Column(name = "destinatario")
    private String destinatario;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "data_spedizione")
    private LocalDateTime data_spedizione;

    @Column(name = "data_ricezione")
    private LocalDateTime data_ricezione;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idSpedizione")
    private List<Contenuto> contenuto;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public LocalDateTime getData_spedizione() {
        return data_spedizione;
    }

    public void setData_spedizione(LocalDateTime data_spedizione) {
        this.data_spedizione = data_spedizione;
    }

    public LocalDateTime getData_ricezione() {
        return data_ricezione;
    }

    public void setData_ricezione(LocalDateTime data_ricezione) {
        this.data_ricezione = data_ricezione;
    }

    @JsonGetter(value = "data_ricezione")
    public String getDatetimeAsStringRicezione() {
        return data_ricezione.format(DateTimeFormatter.ISO_DATE);
    }
    @JsonSetter(value = "data_ricezione")
    public void setDatetimeRicezione(String data) {
        this.data_ricezione = LocalDateTime.parse(data, DateTimeFormatter.ISO_DATE);
    }

    @JsonGetter(value = "data_spedizione")
    public String getDatetimeAsStringSpedizione() {
        return data_spedizione.format(DateTimeFormatter.ISO_DATE);
    }
    @JsonSetter(value = "data_spedizione")
    public void setDatetimeSpedizione(String data) {
        this.data_spedizione = LocalDateTime.parse(data, DateTimeFormatter.ISO_DATE);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("{ id : ").append(this.id)
                .append(", Cod. : ").append(this.codice)
                .append(", destinatario : ").append(this.destinatario)
                .append(", indirizzo : ").append(this.indirizzo)
                .append(", spedizione : ").append(this.getDatetimeAsStringSpedizione())
                .append(", ricezione : ").append(this.getDatetimeAsStringRicezione())
                .append(" }");
        return builder.toString();
    }

    public List<Contenuto> getContenuto() {
        return contenuto;
    }

    public void setContenuto(List<Contenuto> contenuto) {
        this.contenuto = contenuto;
    }
}
