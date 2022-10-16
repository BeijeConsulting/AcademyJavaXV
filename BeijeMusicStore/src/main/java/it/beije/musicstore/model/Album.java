package it.beije.musicstore.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "album")
public class Album {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_artista")
    private Integer idArtista;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "data")
    private LocalDateTime data;


    @Column(name="genere")
    private String genere;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_album")
//    private List<Canzone> canzoni;

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

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

//    public List<Canzone> getCanzoni() {
//        return canzoni;
//    }

//    public void setCanzoni(List<Canzone> canzoni) {
//        this.canzoni = canzoni;
//    }

    public String toString(){
        StringBuilder builder = new StringBuilder()
                .append("id: " + this.id)
                .append(", id_artista: " + this.idArtista)
                .append(", titolo: " + this.titolo)
                .append(", data:" + this.data)
                .append(", genere: " + this.genere);
//                .append(", list Canzoni: " + this.canzoni);
        return builder.toString();
    }
}
