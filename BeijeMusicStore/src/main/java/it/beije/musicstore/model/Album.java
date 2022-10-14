package it.beije.musicstore.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/*
CREATE TABLE `hopper`.`album` (
  `id` int NOT NULL AUTO_INCREMENT,
  `artista_id` int NOT NULL,
  `data` datetime NOT NULL,
  `titolo` VARCHAR(100) NOT NULL,
  `genere` VARCHAR(45) NOT NULL,
  `numerocanzoni` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `artista_fk_idx` (`artista_id`),
  CONSTRAINT `artista_fk` FOREIGN KEY (`artista_id`) REFERENCES `artista` (`id`)
) ENGINE=InnoDB;
 */

@Entity
@Table(name = "album")
public class Album {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "artista_id")
	private Integer artista_id;
	
	@Column(name = "titolo")
	private String titolo;

	@Column(name = "genere")
	private String genere;

	@Column(name = "data")
	private LocalDate data;

	@Column(name = "numerocanzoni")
	private Integer numeroCanzoni;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "album_id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Canzone> canzoni;

	public Integer getId() {
		return id;
	}

	public Integer getArtista_id() {
		return artista_id;
	}

	public void setArtista_id(Integer artista_id) {
		this.artista_id = artista_id;
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

	public Integer getNumeroCanzoni() {
		return numeroCanzoni;
	}

	public void setNumeroCanzoni(Integer numeroCanzoni) {
		this.numeroCanzoni = numeroCanzoni;
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
				", titolo='" + titolo + '\'' +
				", genere='" + genere + '\'' +
				", data=" + data +
				", numeroCanzoni=" + numeroCanzoni +
				", canzoni=" + canzoni +
				'}';
	}
}
