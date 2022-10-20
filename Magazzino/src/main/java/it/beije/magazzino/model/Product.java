package it.beije.magazzino.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


/*
CREATE TABLE `warehouse`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `type` VARCHAR(100) NULL,
  `quantity` INT NOT NULL,
  `description` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`));
 */

@Entity
@Table(name = "products")
@JsonInclude(Include.NON_NULL)
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "description")
	@JsonProperty("description")
	private String description;

	@Column(name = "price")
	private Double price;

	@Column(name = "quantity")
	private Integer quantity;


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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", quantity=" + quantity +
				'}';
	}

	//
//	public String toString() {
//		StringBuilder builder = new StringBuilder()
//				.append("{ id : ").append(this.id)
//				.append(", name : ").append(this.name)
//				.append(", desc : ").append(this.desc)
//				.append(", price : ").append(this.price)
//				.append(", quantity : ").append(this.quantity)
//				.append(", rating : ").append(this.rating)
//				.append(" }");
//
//		return builder.toString();
//	}
}
