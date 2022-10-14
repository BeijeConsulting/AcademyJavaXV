package it.beije.musicstore.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "canzone")
public class Canzone {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_artista")
    private Integer id_artista;

    @Column(name = "id_album")
    private Integer id_album;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "data")
    private LocalDateTime data;

    @Column(name = "genere")
    private String genere;



    //Getter e setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_artista() {
        return id_artista;
    }

    public void setId_artista(Integer id_artista) {
        this.id_artista = id_artista;
    }

    public Integer getId_album() {
        return id_album;
    }

    public void setId_album(Integer id_album) {
        this.id_album = id_album;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
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

    public String toString(){
        StringBuilder builder = new StringBuilder()
                .append("id: ").append(this.id)
                .append(",id_artista: ").append(this.id_artista)
                .append(",genere:").append(this.genere);
        return builder.toString();
    }


}
