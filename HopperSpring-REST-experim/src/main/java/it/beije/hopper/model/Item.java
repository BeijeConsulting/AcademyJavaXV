package it.beije.hopper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
CREATE TABLE `hopper`.`order_items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `desc` VARCHAR(2000) NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `quantity` INT NOT NULL,
  `promo` DECIMAL(10,2) NULL,
  PRIMARY KEY (`id`),
  INDEX `order_fk_idx` (`order_id` ASC) VISIBLE,
  INDEX `product_fk_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `order_fk`
    FOREIGN KEY (`order_id`)
    REFERENCES `hopper`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `product_fk`
    FOREIGN KEY (`product_id`)
    REFERENCES `hopper`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
 */

@Entity
@Table(name = "order_items")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String desc;

	@Column(name = "price")
	private Double price;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "promo")
	private Double promo;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public Double getPromo() {
		return promo;
	}

	public void setPromo(Double promo) {
		this.promo = promo;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", orderId : ").append(this.orderId)
				.append(", productId : ").append(this.productId)
				.append(", name : ").append(this.name)
				.append(", desc : ").append(this.desc)
				.append(", price : ").append(this.price)
				.append(", quantity : ").append(this.quantity)
				.append(", promo : ").append(this.promo)
				.append(" }");
		
		return builder.toString();
	}

}
