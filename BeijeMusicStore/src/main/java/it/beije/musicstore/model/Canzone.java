package it.beije.musicstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "canzone")
public class Canzone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "id_artista")
	private Integer id_artista;

	@Column(name = "id_album")
	private Integer id_album;
	
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

	public Integer getId_album() {
		return id_album;
	}

	public void setId_album(Integer id_album) {
		this.id_album = id_album;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Canzone [id=" + id + ", id_artista=" + id_artista + ", id_album=" + id_album + ", titolo=" + titolo
				+ ", dataDiNascita=" + dataDiNascita + ", genere=" + genere + "]";
	}
	
	
	
	
}

	