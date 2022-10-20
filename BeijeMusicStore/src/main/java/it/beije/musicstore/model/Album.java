package it.beije.musicstore.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @JsonProperty(value = "id_artista")
    @Column(name = "id_artista")
    private Integer idArtista;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "data_di_uscita")
    private LocalDateTime data;

    @Column(name = "genere")
    private String genere;

    @Column(name = "n_canzoni")
    private Integer nCanzoni;
    @JsonProperty(value = "id_album")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_album")
    private List<Canzone> canzoni;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @JsonSetter(value = "data")
    public void setDatetime(String datetime) {
        this.data = LocalDateTime.of(LocalDate.parse(datetime, DateTimeFormatter.BASIC_ISO_DATE), LocalTime.of(0, 0));
    }

    @JsonGetter(value = "data")
    public String getDatetimeAsString() {
        return data.format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public Integer getnCanzoni() {
        return nCanzoni;
    }

    public void setnCanzoni(Integer nCanzoni) {
        this.nCanzoni = nCanzoni;
    }

    public List<Canzone> getCanzoni() {
        return canzoni;
    }

    public void setCanzoni(List<Canzone> canzoni) {
        this.canzoni = canzoni;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", idArtista=" + idArtista +
                ", titolo='" + titolo + '\'' +
                ", data=" + data +
                ", genere='" + genere + '\'' +
                ", nCanzoni=" + nCanzoni +
                ", canzoni=" + canzoni +
                '}';
    }
}
