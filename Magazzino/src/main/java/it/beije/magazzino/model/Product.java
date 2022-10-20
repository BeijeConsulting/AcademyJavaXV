package it.beije.magazzino.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 CREATE TABLE `magazzino`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `typology` VARCHAR(100) NOT NULL,
  `quantity` INT NOT NULL,
  `description` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));
 */

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "typology")
	private String typology;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "description")
	private String description;

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

	public String getTypology() {
		return typology;
	}

	public void setTypology(String typology) {
		this.typology = typology;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isEmpy() {
		boolean isEmpy = true;
	
		if(this.name != null ) isEmpy  = false;		
		if(this.typology != null && isEmpy == true) isEmpy  = false;				
		if(this.quantity > -1 && isEmpy == true) isEmpy  = false;

		return isEmpy;
	}
	
	public boolean checkParameters() {
		if(name.length() <= 0) return false;	
		if(typology.length() <= 0) return false;
		if(quantity < 0) return false;
		
		return true;
	}
	
}
