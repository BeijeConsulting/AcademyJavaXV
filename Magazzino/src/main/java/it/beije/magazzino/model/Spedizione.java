package it.beije.magazzino.model;

import java.time.LocalDate;
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


@Entity
@Table(name = "spedizione")
public class Spedizione {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "codice")
	private Integer codice;
	
	@Column(name = "destinatario")
	private String destinatario;
	
	@Column(name = "data_spedizione")
	private LocalDate dataSpedizione;
	
	@Column(name = "data_ricezione")
	private LocalDate dataRicezione;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "prodotto_id")
	private List<Prodotto> items;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public LocalDate getDataSpedizione() {
		return dataSpedizione;
	}

	public void setDataSpedizione(LocalDate dataSpedizione) {
		this.dataSpedizione = dataSpedizione;
	}

	public LocalDate getDataRicezione() {
		return dataRicezione;
	}

	public void setDataRicezione(LocalDate dataRicezione) {
		this.dataRicezione = dataRicezione;
	}

	@Override
	public String toString() {
		return "Spedizione [id=" + id + ", codice=" + codice + ", destinatario=" + destinatario + ", dataSpedizione="
				+ dataSpedizione + ", dataRicezione=" + dataRicezione + "]";
	}

	

}
