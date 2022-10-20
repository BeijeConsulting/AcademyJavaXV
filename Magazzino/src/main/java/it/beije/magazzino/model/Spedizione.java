package it.beije.magazzino.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "spedizione")
public class Spedizione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "codice")
    private Integer codice;

    @Column(name = "destinatario")
    private String destinatario;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "data_spedizione")
    private LocalDate dataSpedizione;

    @Column(name = "data_ricezione")
    private LocalDate dataRicezione;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "spedizione_id")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<ContenutoSpedizione> contenutoSpedizioneList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
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

    public LocalDate getDataSpedizione() {
        return dataSpedizione;
    }

    public void setDataSpedizione(LocalDate dataSpedizione) {
        this.dataSpedizione = dataSpedizione;
    }

    public LocalDate getDataRicezione() {
        return dataRicezione;
    }

    public void setDataRicezione(LocalDate dataRicezione) {
        this.dataRicezione = dataRicezione;
    }

    public List<ContenutoSpedizione> getContenutoSpedizioneList() {
        return contenutoSpedizioneList;
    }

    public void setContenutoSpedizioneList(List<ContenutoSpedizione> contenutoSpedizioneList) {
        this.contenutoSpedizioneList = contenutoSpedizioneList;
    }

    @Override
    public String toString() {
        return "Spedizione{" +
                "id=" + id +
                ", codice=" + codice +
                ", destinatario='" + destinatario + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", dataSpedizione=" + dataSpedizione +
                ", dataRicezione=" + dataRicezione +
                '}';
    }
}
