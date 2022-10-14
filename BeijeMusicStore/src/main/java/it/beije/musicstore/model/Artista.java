package it.beije.musicstore.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/*
CREATE TABLE `hopper`.`artista` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `genere` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
 */

@Entity
@Table(name = "artista")
public class Artista {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "genere")
	private String genere;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "artista_id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Album> albums;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "artista_id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Canzone> canzoni;

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

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public List<Canzone> getCanzoni() {
		return canzoni;
	}

	public void setCanzoni(List<Canzone> canzoni) {
		this.canzoni = canzoni;
	}

	@Override
	public String toString() {
		return "Artista{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", genere='" + genere + '\'' +
				'}';
	}
}
