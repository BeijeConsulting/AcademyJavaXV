package it.beije.magazzino.model;


//CREATE TABLE `spedizione` (
//		  `id` int NOT NULL AUTO_INCREMENT,
//		  `codice` varchar(45) NOT NULL,
//		  `destinatario` varchar(100) NOT NULL,
//		  `indirizzo` varchar(100) NOT NULL,
//		  `data_spedizione` datetime NOT NULL,
//		  `data_ricezione` datetime NOT NULL,
//		  PRIMARY KEY (`id`)
//		) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
		
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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "spedizione")
public class Spedizione {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "codice")
	private String codice;

	@Column(name = "destinatario")
	private String destinatario;

	@Column(name = "indirizzo")
	private String indirizzo;

	@Column(name = "data_spedizione")
	private LocalDateTime data_spedizione;
	
	@Column(name = "data_ricezione")
	private LocalDateTime data_ricezione;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "spedizione_id")
	private List<ContenutoProdotto> contenuto;
	
	public List<ContenutoProdotto> getContenuto() {
		return contenuto;
	}

	public void setContenuto(List<ContenutoProdotto> contenuto) {
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

	public LocalDateTime getData_spedizione() {
		return data_spedizione;
	}

	@JsonGetter(value = "data_spedizione")
	public String getData_spedizioneAsString() {
		return data_spedizione.format(DateTimeFormatter.BASIC_ISO_DATE);
	}

	public void setData_spedizione(LocalDateTime data_spedizione) {
		this.data_spedizione = data_spedizione;
	}

	@JsonSetter(value = "data_spedizione")
	public void setData_spedizione(String data_spedizione) {
		this.data_spedizione = LocalDateTime.parse(data_spedizione, DateTimeFormatter.BASIC_ISO_DATE);
	}
	
	
	public LocalDateTime getData_ricezione() {
		return data_spedizione;
	}

	@JsonGetter(value = "data_ricezione")
	public String getData_ricezioneAsString() {
		return data_ricezione.format(DateTimeFormatter.BASIC_ISO_DATE);
	}

	public void setData_ricezione(LocalDateTime data_ricezione) {
		this.data_ricezione = data_ricezione;
	}

	@JsonSetter(value = "data_ricezione")
	public void setData_ricezione(String data_ricezione) {
		this.data_ricezione = LocalDateTime.parse(data_ricezione, DateTimeFormatter.BASIC_ISO_DATE);
	}
	
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", codice : ").append(this.codice)
				.append(", destinatario : ").append(this.destinatario)
				.append(", indirizzo : ").append(this.indirizzo)
				.append(", data_spedizione : ").append(this.data_spedizione)
				.append(", data_ricezione : ").append(this.data_ricezione)
				.append(", contenuto : ").append(this.contenuto)
				.append(" }");
		
		return builder.toString();
	}
}
