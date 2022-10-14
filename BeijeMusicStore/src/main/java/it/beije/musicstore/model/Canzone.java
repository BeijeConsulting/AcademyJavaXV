package it.beije.musicstore.model;

import javax.persistence.*;
import java.time.LocalDate;

/*CREATE TABLE `hopper`.`canzone` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `artista_id` INT NOT NULL,
        `album_id` INT NOT NULL,
        `titolo` VARCHAR(45) NOT NULL,
        `data` datetime NOT NULL,
        `genere` VARCHAR(45) NOT NULL,
        PRIMARY KEY (`id`),
        KEY `fk_artista_idx` (`artista_id`),
        CONSTRAINT `fk_artista` FOREIGN KEY (`artista_id`) REFERENCES `artista` (`id`),
        KEY `album_fk_idx` (`album_id`),
        CONSTRAINT `album_fk` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`)
        )ENGINE=InnoDB; */

@Entity
@Table(name = "canzone")
public class Canzone {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "genere")
    private String genere;

    @Column(name = "data")
    private LocalDate data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Canzone{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", genere='" + genere + '\'' +
                ", data=" + data +
                '}';
    }
}
