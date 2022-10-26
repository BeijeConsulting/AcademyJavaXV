package it.beije.magazzino.model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;

@Entity
@Table(name = "spedizione")
public class Spedizione {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "codice")
	private String codice;

	@Column(name = "destinatario")
	private String destinatario;
	
	@Column(name = "indirizzo")
	private String indirizzo;
	
	@Column(name = "data_spedizione")
	private LocalDateTime dataSpedizione;
	
	@Column(name = "data_ricezione")
	private LocalDateTime dataRicezione;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "spedizione_id")
	private List<ContenutoSpedizione> contenuto;
	
	public List<ContenutoSpedizione> getContenuto() {
		return contenuto;
	}

	public void setContenuto(List<ContenutoSpedizione> contenuto) {
		this.contenuto = contenuto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public LocalDateTime getDataSpedizione() {
		return dataSpedizione;
	}
	
	@JsonGetter(value="dataSpedizione")
	public String getDataSpedizioneString() {
		return dataSpedizione.format(DateTimeFormatter.BASIC_ISO_DATE);
	}

	public void setDataSpedizione(LocalDateTime dataSpedizione) {
		this.dataSpedizione = dataSpedizione;
	}

	public LocalDateTime getDataRicezione() {
		return dataRicezione;
	}
	
	@JsonGetter(value="dataRicezione")
	public String getDataRicezioneString() {
		return dataRicezione.format(DateTimeFormatter.BASIC_ISO_DATE);
	}

	public void setDataRicezione(LocalDateTime data_ricezione) {
		this.dataRicezione = data_ricezione;
	}
	
	@Override
	public String toString() {
		return "Spedizione [id=" + id + ", codice=" + codice + ", destinatario=" + destinatario + ", indirizzo="
				+ indirizzo + ", dataSpedizione=" + dataSpedizione + ", dataRicezione=" + dataRicezione + ", contenuto="
				+ contenuto + "]";
	}

	
	
	
	
}

	