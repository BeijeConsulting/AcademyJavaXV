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
@Table(name = "contenuto_spedizione")
public class ContenutoSpedizione {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "spedizione_id")
	private Integer spedizioneId;
	
	@Column(name = "prodotto_id")
	private String prodottoId;
	
	@Column(name = "quantita")
	private Integer quantita;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "prodotto_id")
	private List<Prodotto> items;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "spedizione_id")
	private List<Spedizione> spedizioni;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSpedizioneId() {
		return spedizioneId;
	}

	public void setSpedizioneId(Integer spedizioneId) {
		this.spedizioneId = spedizioneId;
	}

	public String getProdottoId() {
		return prodottoId;
	}

	public void setProdottoId(String prodottoId) {
		this.prodottoId = prodottoId;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public List<Prodotto> getItems() {
		return items;
	}

	public void setItems(List<Prodotto> items) {
		this.items = items;
	}

	public List<Spedizione> getSpedizioni() {
		return spedizioni;
	}

	public void setSpedizioni(List<Spedizione> spedizioni) {
		this.spedizioni = spedizioni;
	}

	@Override
	public String toString() {
		return "ContenutoSpedizione [id=" + id + ", spedizioneId=" + spedizioneId + ", prodottoId=" + prodottoId
				+ ", quantita=" + quantita + ", items=" + items + ", spedizioni=" + spedizioni + "]";
	}

	

}
