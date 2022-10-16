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
    private Integer idArtista;

    @Column(name = "id_album")
    private Integer idAlbum;

    @Column(name = "genere")
    private String genere;

    @Column(name = "nome")
    private String nome;



    //Getter e setter


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

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder()
                .append("id: ").append(this.id)
                .append(", idArtista: ").append(this.idArtista)
                .append(", idAlbum: " + this.idAlbum)
                .append(", genere:").append(this.genere);

        return builder.toString();
    }


}
