package it.beije.musicstore.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="canzone")
public class Canzone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @JsonProperty(value="id_artista")
    @Column(name="id_artista")
    private Integer idArtista;

    @JsonProperty(value="id_album")
    @Column(name="id_album")
    private Integer idAlbum;

    @Column(name="titolo")
    private String titolo;

    @Column(name="data_uscita")
    private LocalDateTime data;

    @Column(name="genere")
    private String genere;
    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }
    @JsonIgnore
    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
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

    @JsonGetter(value = "data")
    public String getDateTimeAsString(){
        return data == null ? null : data.format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
    @JsonSetter(value = "data")
    public void setDateTime(String data){
        System.out.println("datetime pre: " + data);
        this.data = LocalDateTime.of(LocalDate.parse(data, DateTimeFormatter.BASIC_ISO_DATE), LocalTime.of(0, 0));
        System.out.println("datetime post: " + data);
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Canzone{" +
                "id=" + id +
                ", idArtista=" + idArtista +
                ", idAlbum=" + idAlbum +
                ", titolo='" + titolo + '\'' +
                ", data=" + data +
                ", genere='" + genere + '\'' +
                '}';
    }
}
