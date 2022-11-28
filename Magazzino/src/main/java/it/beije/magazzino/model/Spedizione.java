package it.beije.magazzino.model;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.*;
import it.beije.magazzino.model.ContenutoSpedizione;

@Entity
@Table(name = "spedizione")
public class Spedizione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "codice")
    private String codice;

    @Column(name = "destinatario")
    private String destinatario;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "data_spedizione")
    private LocalDateTime dataSpedizione;

    @Column(name = "data_ricezione")
    private LocalDateTime dataRicezione;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonProperty(value = "spedizione_details")
    @JoinColumn(name = "spedizione_id")
    private List<ContenutoSpedizione> contenutoSpedizione;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice() {
        this.codice = "AB-" + this.id;
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

    public LocalDateTime getDataSpedizione() {
        return dataSpedizione;
    }

    @JsonGetter(value = "dataSpedizione")
    public String getDataSpedizioneAsString() {
        return dataSpedizione.format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    public void setDataSpedizione(LocalDateTime dataSpedizione) {
        this.dataSpedizione = dataSpedizione;
    }

    @JsonSetter(value = "dataSpedizione")
    public void setDataSpedizione(String dataSpedizione) {
        this.dataSpedizione = LocalDateTime.of(LocalDate.parse(dataSpedizione, DateTimeFormatter.BASIC_ISO_DATE), LocalTime.of(0, 0));
    }

    public LocalDateTime getDataRicezione() {
        return dataRicezione;
    }

    @JsonGetter(value = "dataRicezione")
    public String getDataRicezioneAsString() {
        return dataRicezione.format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    public void setDataRicezione(LocalDateTime dataRicezione) {
        this.dataRicezione = dataRicezione;
    }

    @JsonSetter(value = "dataSpedizione")
    public void setDataRicezione(String dataRicezione) {
        this.dataRicezione = LocalDateTime.of(LocalDate.parse(dataRicezione, DateTimeFormatter.BASIC_ISO_DATE), LocalTime.of(0, 0));
    }

    public List<ContenutoSpedizione> getContenutoSpedizione() {
        return contenutoSpedizione;
    }

    public void setContenutoSpedizione(List<ContenutoSpedizione> contenutoSpedizione) {
        this.contenutoSpedizione = contenutoSpedizione;
    }


    @Override
    public String toString() {
        return "Spedizione{" +
                "id=" + id +
                ", codice='" + codice + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", dataSpedizione=" + dataSpedizione +
                ", dataRicezione=" + dataRicezione +
                ", contenutoSpedizione=" + contenutoSpedizione +
                '}';
    }
}
