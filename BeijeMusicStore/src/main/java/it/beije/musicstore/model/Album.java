package it.beije.musicstore.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name="album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @JsonIgnore
    @Column(name="id_artista")
    private Integer idArtista;

    @Column(name="titolo")
    private String titolo;

    @Column(name="data_di_uscita")
    private LocalDateTime data;

    @Column(name="genere")
    private String genere;

    @Column(name="n_canzoni")
    private Integer nCanzoni;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="id_album")
    private List<Canzone> canzoni;

    public List<Canzone> getCanzoni() {
        return canzoni;
    }

    public void setCanzoni(List<Canzone> canzoni) {
        this.canzoni = canzoni;
    }

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
    @JsonGetter(value = "data")
    public String getDateTimeAsString(){
        return data.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
    @JsonSetter(value = "data")
    public void setDateTimeAsString(String data){
        this.data= LocalDateTime.parse(data,DateTimeFormatter.ISO_LOCAL_DATE);
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
