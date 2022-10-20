package it.beije.magazzino.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/*CREATE TABLE `magazzino`.`prodotto` (
		  `id` INT NOT NULL AUTO_INCREMENT,
		  `nome` VARCHAR(45) NOT NULL,
		  `tipologia` VARCHAR(45) NOT NULL,
		  `quantità` INT NULL,
		  `descrizione` VARCHAR(2000) NOT NULL,
		  PRIMARY KEY (`id`));
*/
@Entity
@Table(name = "products")
public class Prodotto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "tipologia")
	private String tipologia;

	@Column(name = "quantità")
	private int quantità;

	@Column(name = "descrizione")
	private String descrizione;



	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipologia;
	}

	public void setTipo(String tipologia) {
		this.tipologia = tipologia;
	}

	public int getQuantity() {
		return quantità;
	}

	public void setQuantity(int quantità) {
		this.quantità = quantità;
	}


	public String getDesc() {
		return descrizione;
	}

	public void setDesc(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", nome : ").append(this.nome)
				.append(", tipologia : ").append(this.tipologia)
				.append(", Quantità : ").append(this.quantità)
				.append(", Descrizione: ").append(this.descrizione)
				
				.append(" }");
		
		return builder.toString();
	}
}

