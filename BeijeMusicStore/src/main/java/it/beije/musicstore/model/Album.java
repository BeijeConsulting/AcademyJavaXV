package it.beije.musicstore.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

//CREATE TABLE `album` (
//        `id` int NOT NULL AUTO_INCREMENT,
//        `titolo` varchar(45) NOT NULL,
//        `data` datetime NOT NULL,
//        `genere` varchar(45) DEFAULT NULL,
//        `idArtista` int NOT NULL,
//        PRIMARY KEY (`id`),
//        KEY `artista_fk_idx` (`idArtista`),
//        CONSTRAINT `artista_fk` FOREIGN KEY (`idArtista`) REFERENCES `artista` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
//        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty(value = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "idArtista")
    private Integer idArtista;

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
	public String getDataAsString() {
		return data.format(DateTimeFormatter.BASIC_ISO_DATE);
	}

    public void setData(LocalDateTime data) {
        this.data = data;
    }

	@JsonSetter(value = "data")
	public void setData(String data) {
		this.data = LocalDateTime.parse(data, DateTimeFormatter.BASIC_ISO_DATE);
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
                .append(", titolo : ").append(this.titolo)
                .append(", data : ").append(this.data)
                .append(", genere : ").append(this.genere)
                .append(" }");
        return builder.toString();
    }
}
