package it.beije.magazzino.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "prodotti")
public class ContenutoProdotto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "spedizione_id")
	private Integer spedizione_id;

	@Column(name = "prodotti_id")
	private Integer prodotti_id;

	@Column(name = "quantità")
	private Integer quantity;



	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSpedizione_id() {
		return spedizione_id;
	}

	public void setSpedizione_id(Integer spedizione_id) {
		this.spedizione_id = spedizione_id;
	}

	public Integer getProdotti_id() {
		return prodotti_id;
	}

	public void setProdotti_id(Integer prodotti_id) {
		this.prodotti_id = prodotti_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", spedizione_id : ").append(this.spedizione_id)
				.append(", prodotti_id : ").append(this.prodotti_id)
				.append(", quantity : ").append(this.quantity)
				.append(" }");
		
		return builder.toString();
	}
}
