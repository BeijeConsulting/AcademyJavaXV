package it.beije.magazzino.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* 	TABELLA PRODOTTI

CREATE TABLE `hopper`.`prodotto` (
 `id` INT NOT NULL AUTO_INCREMENT,
 `nome` VARCHAR(100) NOT NULL,
 `tipologia` VARCHAR(45) NOT NULL,
 `quantità` INT NOT NULL,
 `descrizione` VARCHAR(2000) NULL DEFAULT NULL,
 PRIMARY KEY (`id`));

*/

@Entity
@Table(name = "prodotti")
public class Prodotto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column
	private String nome;
	
	@Column
	private String tipologia;
	
	@Column
	private Integer quantità;
	
	@Column
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

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Integer getQuantità() {
		return quantità;
	}

	public void setQuantità(Integer quantità) {
		this.quantità = quantità;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String toString() {
		
		StringBuilder prodotto = new StringBuilder()
				.append("{ id = " + this.id + "; ")
				.append("nome = " + this.nome + "; ")
				.append("tipologia = " + this.tipologia + "; ")
				.append("quantità = " + this.quantità + "; ")
				.append("descrizione = " + this.descrizione + " }");
		
		return prodotto.toString();
	}

}
