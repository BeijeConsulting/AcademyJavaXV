package it.beije.musicstore.model;

import javax.persistence.*;
import java.time.LocalDateTime;

//CREATE TABLE `canzone` (
//        `id` int NOT NULL AUTO_INCREMENT,
//        `idArtista` int NOT NULL,
//        `idAlbum` int NOT NULL,
//        `titolo` varchar(45) NOT NULL,
//        `data` datetime NOT NULL,
//        `genere` varchar(45) DEFAULT NULL,
//        PRIMARY KEY (`id`),
//        KEY `artista_fk_idx` (`idArtista`),
//        KEY `album_fk_idx` (`idAlbum`),
//        CONSTRAINT `album_fk1` FOREIGN KEY (`idAlbum`) REFERENCES `album` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
//        CONSTRAINT `artista_fk1` FOREIGN KEY (`idArtista`) REFERENCES `artista` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
//        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

@Entity
@Table(name = "canzone")
public class Canzone {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "idArtista")
    private Integer idArtista;

    @Column(name = "idAlbum")
    private Integer idAlbum;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "data")
    private LocalDateTime data;

    @Column(name = "genere")
    private String genere;


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

    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("{ id : ").append(this.id)
                .append(", idArtista : ").append(this.idArtista)
                .append(", idAlbum : ").append(this.idAlbum)
                .append(", titolo : ").append(this.titolo)
                .append(", data : ").append(this.data)
                .append(", genere : ").append(this.genere)
                .append(" }");
        return builder.toString();
    }
}
