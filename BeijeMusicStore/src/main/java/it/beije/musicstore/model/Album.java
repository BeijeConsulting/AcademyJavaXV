package it.beije.musicstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "album")
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "id_artista")
	private Integer id_artista;

	@Column(name = "titolo")
	private String titolo;
	
	@Column(name = "data_di_nascita")
	private String dataDiNascita;
	
	@Column(name = "genere")
	private String genere;

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

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getData_di_nascita() {
		return dataDiNascita;
	}

	public void setData_di_nascita(String data_di_nascita) {
		this.dataDiNascita = data_di_nascita;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", id_artista=" + id_artista + ", titolo=" + titolo + ", data_di_nascita="
				+ dataDiNascita + ", genere=" + genere + "]";
	}

	
	



}
