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
	private Integer artistaId;

	@Column(name = "id_album")
	private Integer albumId;
	
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

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
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
		return "Canzone [id=" + id + ", artistaId=" + artistaId + ", albumId=" + albumId + ", titolo=" + titolo
				+ ", dataDiUscita=" + dataDiUscita + ", genere=" + genere + "]";
	}


	

	
	
	
	
}

	