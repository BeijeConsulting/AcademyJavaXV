package it.beije.magazzino.model;


//CREATE TABLE `contenuto_spedizione` (
//		  `id` int NOT NULL AUTO_INCREMENT,
//		  `spedizione_id` int NOT NULL,
//		  `prodotti_id` int NOT NULL,
//		  `quantità` int NOT NULL,
//		  PRIMARY KEY (`id`),
//		  KEY `spedizione_fk_idx` (`spedizione_id`),
//		  KEY `prodotti_fk_idx` (`prodotti_id`),
//		  CONSTRAINT `prodotti_fk` FOREIGN KEY (`prodotti_id`) REFERENCES `prodotti` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
//		  CONSTRAINT `spedizione_fk` FOREIGN KEY (`spedizione_id`) REFERENCES `spedizione` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
//		) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "contenuto_spedizione")
public class ContenutoProdotto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "spedizione_id")
	private Integer spedizioneId;

	@Column(name = "prodotti_id")
	private Integer prodottiId;

	@Column(name = "quantità")
	private Integer quantity;



	
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

	public Integer getProdottiId() {
		return prodottiId;
	}

	public void setProdottiId(Integer prodottiId) {
		this.prodottiId = prodottiId;
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
				.append(", spedizione_id : ").append(this.spedizioneId)
				.append(", prodotti_id : ").append(this.prodottiId)
				.append(", quantity : ").append(this.quantity)
				.append(" }");
		
		return builder.toString();
	}
}
