package it.beije.hopper.model;

import javax.persistence.*;

@Entity
@Table(name = "prodotto")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "tipologia")
	private String tipo;

	@Column(name = "quantita")
	private Integer quantita;

	@Column(name = "descrizione")
	private String descrizione;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(" - nome : ").append(this.nome)
				.append(" - tipo : ").append(this.tipo)
				.append(" - quantità : ").append(this.quantita)
				.append(" - desc : ").append(this.descrizione)
				.append(" }");

		return builder.toString();
	}
}
