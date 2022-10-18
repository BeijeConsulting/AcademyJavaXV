package it.beije.musicstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.beije.musicstore.enums.Genere;

import javax.persistence.*;
import java.util.List;

//CREATE TABLE `artista` (
//        `id` int NOT NULL AUTO_INCREMENT,
//        `nome` varchar(45) NOT NULL,
//        `genere` varchar(45) DEFAULT NULL,
//        PRIMARY KEY (`id`),
//        CONSTRAINT `album_fk` FOREIGN KEY (`id`) REFERENCES `album` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
//        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

@Entity
@Table(name = "artista")
public class Artista {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty(value = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "genere")
    private String genere;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "artista_id")
//    private List<Album> albums;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
                .append(", nome : ").append(this.nome)
                .append(", genere : ").append(this.genere)
               // .append(", albums : ").append(this.albums)
                .append(" }");
        return builder.toString();
    }

//    public List<Album> getAlbums() {
//        return albums;
//    }
//
//    public void setAlbums(List<Album> albums) {
//        this.albums = albums;
//    }
}
