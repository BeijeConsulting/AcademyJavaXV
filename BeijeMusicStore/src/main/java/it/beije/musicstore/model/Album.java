package it.beije.musicstore.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;



@Entity
@Table(name = "album")
public class Album {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "id_artista")
	private Integer artistaId;

	@Column(name = "titolo")
	private String titolo;
	
	@Column(name = "data_di_uscita")
	private String dataDiUscita;
	
	@Column(name = "genere")
	private String genere;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArtistaId() {
		return artistaId;
	}

	public void setArtistaId(Integer artistaId) {
		this.artistaId = artistaId;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getDataDiUscita() {
		return dataDiUscita;
	}
	

	public void setDataDiUscita(String dataDiUscita) {
		this.dataDiUscita = dataDiUscita;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", id_artista=" + artistaId + ", titolo=" + titolo + ", data_di_nascita="
				+ dataDiUscita + ", genere=" + genere + "]";
	}

	
	



}
