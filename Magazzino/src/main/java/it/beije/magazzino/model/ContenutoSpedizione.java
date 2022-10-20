package it.beije.magazzino.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contenuto_spedizione")
public class ContenutoSpedizione {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "spedizione_id")
	private Integer idSpedizione;

	@Column(name = "prodotto_id")
	private Integer idProdotto;
	
	@Column(name = "quantita")
	private Integer quantita;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdSpedizione() {
		return idSpedizione;
	}

	public void setIdSpedizione(Integer idSpedizione) {
		this.idSpedizione = idSpedizione;
	}

	public Integer getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "ContenutoSpedizione [id=" + id + ", idSpedizione=" + idSpedizione + ", idProdotto=" + idProdotto
				+ ", quantita=" + quantita + "]";
	}
	
	
	
}
	