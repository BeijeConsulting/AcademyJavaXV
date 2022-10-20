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
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome")
	private String name;

	@Column(name = "tipologia")
	private String tipo;

	@Column(name = "quantità")
	private Integer quantity;

	@Column(name = "descrizione")
	private String desc;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", name : ").append(this.name)
				.append(", desc : ").append(this.desc)
				.append(", tipo : ").append(this.tipo)
				.append(", quantity : ").append(this.quantity)
				.append(" }");
		
		return builder.toString();
	}
}
